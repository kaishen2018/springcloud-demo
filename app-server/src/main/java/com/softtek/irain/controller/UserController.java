package com.softtek.irain.controller;


import com.alibaba.fastjson.JSON;
import com.softtek.irain.domain.User;
import com.softtek.irain.repository.TokenRepository;
import com.softtek.irain.repository.UserRepository;
import com.softtek.irain.utils.FileUtils;
import com.softtek.irain.vo.ServerResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1")
@RestController
@Slf4j(topic = "UserController")
@Api("UserController 相关的接口")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenRepository tokenRepository;


    @Value("${file.upload.path}")
    private String UPLOAD_FILE_PATH;

    /**
     * 添加用户
     * @param user 用户信息2
     * @return 添加成功后的用户id
     */
    @PostMapping("/users")
    @ApiOperation(value = "创建用户", notes = "create user")
    @ApiImplicitParam(name = "user", dataType = "User")
//    @ApiModel
    public ServerResult saveUser(@RequestBody User user){

        log.info("request parameter: {}", JSON.toJSON(user) );
        User saveUser = userRepository.save(user);
        log.info("response body: {}", JSON.toJSON(saveUser) );
        return new ServerResult("200", "Success",saveUser.getId());
    }

    /**
     * 更新用户信息
     * @param user 用户信息
     * @param id 用户id
     * @return 更新结果
     */
    @PutMapping("/users/{id}")
    public ServerResult updateUserById(@RequestBody User user,@PathVariable Long id){
        user.setId(id);
        userRepository.save(user);
        return new ServerResult("200", "Success",user.getId());
    }

    /**
     * 获取用户信息
     * @param id 用户id
     * @return 用户信息
     */
    @GetMapping("/users/{id}")
    public ServerResult findUserById(@PathVariable Long id){
        User user = userRepository.findById(id).orElse(null);
        return new ServerResult("200", "Success",user);
    }

    /**
     * 删除用户信息
     * @param id 用户id
     * @return 删除结果
     */
    @DeleteMapping("/users/{id}")
    public ServerResult deleteUserById(@PathVariable Long id){
        userRepository.deleteById(id);
        return new ServerResult("200", "Success", null);
    }

    /**
     * 获取用户列表
     * @return 用户列表
     */
    @GetMapping("/users")
    public ServerResult findUsers(){
        List list = userRepository.findAll();
        return new ServerResult("200", "Success", list);
    }

    @PostMapping("/users/login")
    public ServerResult login(@RequestBody User user){
        log.info("request parameter: {}", JSON.toJSON(user) );
        String token = UUID.randomUUID().toString();
        tokenRepository.setKey(token, user.getUserName());
        log.info("response body: {}", JSON.toJSON(token) );
        return new ServerResult("200", "Success", token);
    }

    @ApiOperation(value = "用户详情", notes = "用户详情描述，根据 token 获取用户名")
    @GetMapping("/users/detail")
    public ServerResult getUserDetail(@RequestHeader String token){
        log.info("request parameter: {}", JSON.toJSON(token) );
        String userName = tokenRepository.getValue(token);
        log.info("response body: {}", JSON.toJSON(userName) );
        return new ServerResult("200", "Success", userName);
    }

    @PostMapping("/file/upload")
    public ServerResult uploadFileupload(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        log.info("request parameter: {}", file.getName() );
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        /*System.out.println("fileName-->" + fileName);
        System.out.println("getContentType-->" + contentType);*/
        String filePath = UPLOAD_FILE_PATH;
        try {
            FileUtils.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return new ServerResult("200", "Success", filePath);
    }
}
