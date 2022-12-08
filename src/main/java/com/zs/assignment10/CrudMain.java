package com.zs.assignment10;

import com.zs.assignment10.controller.CrudController;
import com.zs.assignment10.service.CrudService;

public class CrudMain {
    public static void main(String[] args) {

        CrudController crudController=new CrudController();
        crudController.run();

    }
}

