
1、访问授权页面：
http://localhost:8040/oauth/authorize?client_id=client&client_secret=secret&response_type=code&redirect_uri=http://www.baidu.com

2、拿到`code`以后，就可以调用
POST/GET http://client:secret@localhost:8040/oauth/token

3、获取token
curl -X POST -H "Content-Type: application/x-www-form-urlencoded" -d 'grant_type=authorization_code&code=7XMmyq&redirect_uri=http://www.baidu.com' "http://client:secret@localhost:8040/oauth/token"
返回json如下：
{
  "access_token": "32a1ca28-bc7a-4147-88a1-c95abcc30556", // 令牌
  "token_type": "bearer",
  "expires_in": 2591999,
  "scope": "app"
}