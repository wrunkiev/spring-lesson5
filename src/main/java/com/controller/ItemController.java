package com.controller;

import com.model.Item;
import com.dao.ItemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@Controller
public class ItemController {
    @Autowired
    private ItemDAO dao;

    public ItemController(ItemDAO dao){
        this.dao = dao;
    }

    @PostMapping(value = "/item/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public Item save(@RequestBody Item item)throws Exception{
        return dao.save(item);
        //Item item = new Item();
        //item.setDescription("spring basics spring gromcode");
        //dao.save(item);
        //return "ok";
    }

    /*@RequestMapping(method = RequestMethod.GET, value = "/save-item", produces = "text/plain")
    public @ResponseBody String saveOrder(){
        Item item = new Item();
        item.setDescription("spring basics spring gromcode");
        dao.save(item);
        return "ok";
    }*/



}
