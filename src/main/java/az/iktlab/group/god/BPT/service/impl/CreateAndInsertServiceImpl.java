package az.iktlab.group.god.BPT.service.impl;

import az.iktlab.group.god.BPT.dao.repository.impl.CreateAndInsertDaoImpl;

public class CreateAndInsertServiceImpl {

    private final CreateAndInsertDaoImpl createDao;

    public CreateAndInsertServiceImpl() {
        this.createDao =  new CreateAndInsertDaoImpl();
    }

    public static void run(){
        CreateAndInsertServiceImpl createService = new CreateAndInsertServiceImpl();
        createService.createDao.createDb();
        createService.createDao.createTable();
        createService.createDao.insertPerson();
        createService.createDao.insertFlight();
    }
}
