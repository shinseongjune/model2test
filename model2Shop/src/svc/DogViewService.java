package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.DogDAO;
import vo.Dog;

public class DogViewService {

	public Dog getDogView(int id) {
		Connection conn = getConnection();
		DogDAO dogDAO = DogDAO.getInstance();
		dogDAO.setConnection(conn);
		int updateCount = dogDAO.updateReadCount(id);
		
		if(updateCount > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		Dog dog = dogDAO.selectDog(id);
		close(conn);
		return dog;
	}

}
