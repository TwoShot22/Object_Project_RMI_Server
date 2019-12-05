package home.frameworks;

import java.io.FileNotFoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import home.model.UserModel;

public interface LoginInterface extends Remote{
	
	public UserModel getUser() throws RemoteException;
	
	// Login DB�� ����� �Է°� �� �޼ҵ�
	public boolean authenticate(String inputID, String inputPassword) throws FileNotFoundException, RemoteException;
		
}