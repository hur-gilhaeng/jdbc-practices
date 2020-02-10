package hr;

import java.util.List;
import java.util.Scanner;

public class HRMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("이름> ");
		String name = scanner.nextLine();
		
		EmployeeVo vo = new EmployeeVo();
		vo.setFirstName(name);
		
		EmployeeDao dao = new EmployeeDao();
		List<EmployeeVo> list = dao.findByName(vo);
		
		for(EmployeeVo vos : list) {
			System.out.println(vos);
		}
		
		scanner.close();
	}

}
