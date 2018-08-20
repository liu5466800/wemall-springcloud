package cn.segema.cloud.filecenter.controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import cn.segema.cloud.common.constants.StatusConstant;
import cn.segema.cloud.common.utils.IdGeneratorUtil;
import cn.segema.cloud.common.vo.ResultVO;
import cn.segema.cloud.filecenter.domain.Filecenter;
import cn.segema.cloud.filecenter.repository.FilecenterRepository;
import cn.segema.cloud.filecenter.util.FileUtil;

/**
 * 文件中心接口
 */
@Controller
@RequestMapping(value = "/filecenter")
public class FilecenterController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private FilecenterRepository filecenterRepository;
	
	@Value("${segema.filecenter.localDirectory}")
	private String filecenterLocalDirectory;
	
	@Value("${segema.filecenter.dataSourceSave}")
	private boolean dataSourceSave;
	
	@RequestMapping(value="/uploadfile", method = RequestMethod.GET)
    public String uploadFile() {
        return "uploadfile";
    }

    //处理文件单个上传
    @RequestMapping(value="/uploadfile", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO uploadfile(@RequestParam("file") MultipartFile file,String businessId,String businessCode, String fileDesc,
            HttpServletRequest request) {
    		ResultVO resultVO = new ResultVO();
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        //过滤掉特殊字符
        fileName = removeSpecialSymbol(fileName);
        String localDirectory = filecenterLocalDirectory;
        try {
        		BigInteger fileId = BigInteger.valueOf(IdGeneratorUtil.generateSnowFlakeId());
            FileUtil.uploadFile(file.getBytes(), localDirectory+fileId+"/", fileName);
            Filecenter filecenter = new Filecenter();
            filecenter.setFileId(fileId);
            filecenter.setFileName(fileName);
            filecenter.setFileType(contentType);
            filecenter.setRelativePath(fileId+"/"+fileName);
            filecenter.setSuffix(fileName.substring(fileName.lastIndexOf(".")));
            filecenter.setAbsolutePath(localDirectory+fileId+"/"+fileName);
            filecenter.setTotalSize(new BigDecimal(file.getSize()));
            if(dataSourceSave) {
            		filecenter.setFileContent(file.getBytes());
            }
            filecenter.setBusinessCode(businessId);
            filecenter.setBusinessCode(businessCode);
            filecenter.setDescription(fileDesc);
            filecenterRepository.save(filecenter);
            resultVO.setStatus(StatusConstant.SUCCESS);
            resultVO.setData(filecenter);
        } catch (Exception e) {
        		logger.error(e.getMessage());
        		resultVO.setStatus(StatusConstant.FAILED);
        		resultVO.setMessage(e.getMessage());
        }
        return resultVO;
    }
    
    
    /**
	 * 同步执行上传文件和更新备注
	 * @param files
	 * @param businessId 业务数据ID
	 * @param businessCode 业务数据编码
	 * @param fileDescs 文件描述
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/uploadfiles", method = RequestMethod.POST)
	@ResponseBody
	public ResultVO uploadfiles(@RequestParam("file") MultipartFile[] files,String businessId,String businessCode, String[] fileDescs, HttpServletRequest request, HttpServletResponse response){
		
		ResultVO resultVO = new ResultVO();
		String localDirectory = filecenterLocalDirectory;
		if(files!=null&&files.length>0) {
			
			List<Filecenter> entities = new ArrayList<>();
			try {
				for(int i=0;i<files.length;i++) {
					MultipartFile file = files[i];
					String contentType = file.getContentType();
			        String fileName = file.getOriginalFilename();
			        //过滤掉特殊字符
			        fileName = removeSpecialSymbol(fileName);
		        		BigInteger fileId = BigInteger.valueOf(IdGeneratorUtil.generateSnowFlakeId());
		            FileUtil.uploadFile(file.getBytes(), localDirectory+fileId+"/", fileName);
		            Filecenter filecenter = new Filecenter();
		            filecenter.setFileId(fileId);
		            filecenter.setFileName(fileName);
		            filecenter.setFileType(contentType);
		            filecenter.setRelativePath(fileId+"/"+fileName);
		            filecenter.setSuffix(fileName.substring(fileName.lastIndexOf(".")));
		            filecenter.setAbsolutePath(localDirectory+fileId+"/"+fileName);
		            filecenter.setTotalSize(new BigDecimal(file.getSize()));
		            if(dataSourceSave) {
		            		filecenter.setFileContent(file.getBytes());
		            }
		            filecenter.setBusinessCode(businessId);
		            filecenter.setBusinessCode(businessCode);
		            if(fileDescs.length>=i+1) {
		            		filecenter.setDescription(fileDescs[i]);
					}
		            entities.add(filecenter);
				}
				filecenterRepository.saveAll(entities);
				
				resultVO.setStatus(StatusConstant.SUCCESS);
				resultVO.setMessage("上传成功");
				resultVO.setData(entities);
				
			} catch (Exception e) {
				resultVO.setStatus(StatusConstant.FAILED);
				resultVO.setMessage(e.getMessage());
			}
		}else {
			resultVO.setStatus(StatusConstant.FAILED);
			resultVO.setMessage("没有上传文件");
		}
		
		return resultVO;
	}
    
    /**
	 * 下载文件
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/download/{id}",method = RequestMethod.GET)
	public void download(@PathVariable("id") BigInteger id,HttpServletRequest request,
			HttpServletResponse response){
		Optional<Filecenter> filecenter  = filecenterRepository.findById(id);
//		String storeName = filecenter.getAbsolutePath();
//		String fileName = filecenter.getFileName();
		String storeName = "";
		String fileName = "";
		String contentType = "application/x-download";
		try {
			FileUtil.download(request, response, storeName, contentType,fileName);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}
	
	
	/**
	 * 根据业务ID获取所有文件
	 * @param businessId
	 * @return
	 */
	@RequestMapping(value ="/files/{businessId}",method = RequestMethod.GET)
	@ResponseBody
	public ResultVO getfilesByBusinessId(@PathVariable("businessId")BigInteger businessId){
		List<Filecenter> entities = filecenterRepository.getfilesByBusinessId(businessId);
		ResultVO resultVO = new ResultVO();
		resultVO.setStatus(StatusConstant.SUCCESS);
		resultVO.setMessage("获取文件成功");
		resultVO.setData(entities);
		return resultVO;
	}
	
	/**
	 * 根据业务ID,Code获取所有文件
	 * @param businessId
	 * @param businessCode
	 * @return
	 */
	@RequestMapping(value ="/files/{businessId}/{businessCode}",method = RequestMethod.GET)
	@ResponseBody
	public ResultVO getfilesByBusinessIdAndCode(@PathVariable("businessId")BigInteger businessId,@PathVariable("businessCode")String businessCode){
		List<Filecenter> entities = filecenterRepository.getfilesByBusinessIdAndCode(businessId,businessCode);
		ResultVO resultVO = new ResultVO();
		resultVO.setStatus(StatusConstant.SUCCESS);
		resultVO.setMessage("获取文件成功");
		resultVO.setData(entities);
		return resultVO;
	}
	
	
	/**
	 * 过滤掉特殊字符
	 * @param fileName
	 * @return
	 */
	private String removeSpecialSymbol(String fileName) {
		String regEx="[`~!@#$%^&*()+=|{}':;',\\[\\]<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(fileName);
		fileName = m.replaceAll("").trim();
		return fileName;
	}

	
}
