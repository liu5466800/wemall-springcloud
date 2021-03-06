package cn.segema.cloud.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.segema.cloud.demo.service.ClickhouseTestService;
import cn.segema.cloud.demo.vo.DemoCarTransactionVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/demo/clickhouse")
public class DemoClickhouseController {
 
  @Autowired
  private ClickhouseTestService clickhouseTestService;
  
  
  @GetMapping("/save")
	public String save() {
		DemoCarTransactionVO carsTransactionsVO = new DemoCarTransactionVO();
		carsTransactionsVO.setPrice(123);
		carsTransactionsVO.setColor("red");
		carsTransactionsVO.setMake("HONDA");
		carsTransactionsVO.setSold(new Date());
		clickhouseTestService.save(carsTransactionsVO);
		return "success";
	}

	@GetMapping("/delete")
	public String delete(Integer id) {
		clickhouseTestService.deleteById(id);
		return "success";
	}

	@GetMapping("/update")
	public String update(Integer id, String name, String description) {
		DemoCarTransactionVO carsTransactionsVO = new DemoCarTransactionVO();
		clickhouseTestService.save(carsTransactionsVO);
		return "success";
	}
	
	@GetMapping("/list")
	public List<DemoCarTransactionVO> list() {
		List<DemoCarTransactionVO> carsTransactionsVO = (List<DemoCarTransactionVO>) clickhouseTestService.findList();
		return carsTransactionsVO;
	}

	@GetMapping("/getOne")
	public DemoCarTransactionVO getOne(Integer id) {
		DemoCarTransactionVO carsTransactionsVO = (DemoCarTransactionVO) clickhouseTestService.findById(id);
		return carsTransactionsVO;
	}

  @ApiOperation(value="获取信息", notes="根据id获取信息") 
  @ApiImplicitParams({  
          @ApiImplicitParam(name = "id", value = "SonarUrl表ID", required = true, dataType = "Long", paramType="path")  
  })
  @GetMapping("/{id}")
  public Map findById(@PathVariable Long id) {
	  Map map = new HashMap<String,String>();
	  map.put("key1", "value1");
	  map.put("key2", "value2");
	  map.put("key3", "value3");
	  return map;
  }
  
}
