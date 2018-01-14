package com.hdu.controller;

import com.hdu.domain.User;
import com.hdu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 范正荣
 * @Date 2017/12/16 0016 20:02.
 */
@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    private UserRepository userRepository;

    /**
     * 查询所有用户
     * @param model
     * @return
     */
    @GetMapping
     public ModelAndView list(Model model){
        model.addAttribute("userList",userRepository.findAll());
        model.addAttribute("title","用户管理");
        return new ModelAndView("users/list","userModel",model);
     }

    /**
     * 根据id查询用户
     * @param id
     * @param model
     * @return
     */
     @GetMapping("{id}")
     public ModelAndView view(@PathVariable("id") Long id, Model model){
         User user = userRepository.findOne(id);
         model.addAttribute("user",user);
         model.addAttribute("title","查看用户");
         return new ModelAndView("users/view","userModel",model);
     }

    /**
     * 获取创建表单页面
     * @param model
     * @return
     */
    @GetMapping("/form")
    public ModelAndView createForm(Model model){
        model.addAttribute("user",new User(null,null,null));
        model.addAttribute("title","创建用户");
        return new ModelAndView("users/form","userModel",model);
    }

    @PostMapping
    public ModelAndView create(User user){
        user = userRepository.save(user);
        return new ModelAndView("redirect:/users");
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @GetMapping(value = "delete/{id}")
    public ModelAndView delete(@PathVariable("id")Long id){
        userRepository.delete(id);
        return new ModelAndView("redirect:/users");
    }
    /**
     * 修改用户
     * @param id
     * @return
     */
    @GetMapping(value = "modify/{id}")
    public ModelAndView delete(@PathVariable("id")Long id,Model model){
        User user = userRepository.findOne(id);
        model.addAttribute("user",user);
        model.addAttribute("title","修改用户");
        return new ModelAndView("users/form","userModel",model);
    }
}