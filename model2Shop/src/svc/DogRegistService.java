package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.DogDAO;
import vo.Dog;

public class DogRegistService {

	public boolean registDog(Dog dog) {
		DogDAO dogDAO = DogDAO.getInstance();
		Connection conn = getConnection();
		dogDAO.setConnection(conn);
		boolean isRegistSuccess = false;
		int insertCount = dogDAO.insertDog(dog);
		
		if(insertCount > 0) {
			commit(conn);
			isRegistSuccess = true;
		} else {
			rollback(conn);
		}
		
		close(conn);
		return isRegistSuccess;
	}

}
