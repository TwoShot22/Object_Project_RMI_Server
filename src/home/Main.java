package home;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import home.controls.BasketControl;
import home.controls.LoginControl;
import home.controls.SignUpControl;
import home.controls.TableControl;
import home.controls.UserInfoControl;
import home.fileController.CheckDuplication;
import home.fileController.FileTool;
import home.frameworks.BasketInterface;
import home.frameworks.CheckDuplicationInterface;
import home.frameworks.FileToolInterface;
import home.frameworks.LoginInterface;
import home.frameworks.SignUpInterface;
import home.frameworks.TableInterface;
import home.frameworks.UserInfoInterface;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasketControl basketControl = new BasketControl();
		LoginControl loginControl = new LoginControl();
		SignUpControl signUpControl = new SignUpControl();
		TableControl tableControl = new TableControl();
		UserInfoControl userInfoControl = new UserInfoControl();
		CheckDuplication checkDuplication = new CheckDuplication();
		FileTool fileTool = new FileTool();
		
		BasketInterface basketInterface;
		LoginInterface loginInterface;
		SignUpInterface signUpInterface;
		TableInterface tableInterface;
		UserInfoInterface userInfoInterface;
		CheckDuplicationInterface checkDuplicationInterface;
		FileToolInterface fileToolInterface;
		 
		try {
			basketInterface = (BasketInterface) UnicastRemoteObject.exportObject(basketControl, 0);
			loginInterface = (LoginInterface) UnicastRemoteObject.exportObject(loginControl, 0);
			signUpInterface = (SignUpInterface) UnicastRemoteObject.exportObject(signUpControl, 0);
			tableInterface = (TableInterface) UnicastRemoteObject.exportObject(tableControl, 0);
			userInfoInterface = (UserInfoInterface) UnicastRemoteObject.exportObject(userInfoControl, 0);
			checkDuplicationInterface = (CheckDuplicationInterface) UnicastRemoteObject.exportObject(checkDuplication, 0);
			fileToolInterface = (FileToolInterface) UnicastRemoteObject.exportObject(fileTool, 0);
			
			Registry registry = LocateRegistry.getRegistry();
			
			registry.bind("basket", basketInterface);
			registry.bind("login", loginInterface);
			registry.bind("signup", signUpInterface);
			registry.bind("table", tableInterface);
			registry.bind("userinfo", userInfoInterface);
			registry.bind("checkduplication", checkDuplicationInterface);
			registry.bind("filetool", fileToolInterface);
			
			System.out.println("통신 준비 완료");
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
