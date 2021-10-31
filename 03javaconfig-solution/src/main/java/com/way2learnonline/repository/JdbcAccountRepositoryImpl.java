package com.way2learnonline.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.way2learnonline.model.*;


@Component
public class JdbcAccountRepositoryImpl implements AccountRepository {
	
	@Autowired
	private DataSource dataSource;
	
	public JdbcAccountRepositoryImpl() {
		
	}
		

	
	

	public JdbcAccountRepositoryImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	


	public Account findAccountByNumber(Long accountNUmber) throws SQLException {
		String query="select * from account a where a.accountNumber=? ";
		Connection connection=dataSource.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setLong(1, accountNUmber);
		ResultSet rs=preparedStatement.executeQuery();
		Account account=null;
		if(rs.next()){
			 account= new Account();
			 account.setName(rs.getString("name"));
			account.setAccountNumber(rs.getLong("accountNumber"));
			account.setActive(rs.getBoolean("isactive"));
			Address address= new Address();
			address.setCity(rs.getString("city"));
			address.setCountry(rs.getString("country"));
			account.setAddress(address);
			account.setBalance(rs.getInt("balance"));
			account.setEmailAddress(rs.getString("emailaddress"));
			
		}
		connection.close();
		return account;
	}

	public List<Account> findAllAccounts() throws SQLException {
		String query="select * from account  ";
		Connection connection=dataSource.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);

		ResultSet rs=preparedStatement.executeQuery();
		List<Account> accounts= null;
		while(rs.next()){
			if(accounts==null){
				accounts= new ArrayList<Account>();
			}
			Account account= new Account();
			 account.setName(rs.getString("name"));
			account.setAccountNumber(rs.getLong("accountNumber"));
			account.setActive(rs.getBoolean("isactive"));
			Address address= new Address();
			address.setCity(rs.getString("city"));
			address.setCountry(rs.getString("country"));
			account.setAddress(address);
			account.setBalance(rs.getInt("balance"));
			account.setEmailAddress(rs.getString("emailaddress"));
			accounts.add(account);
		}
		connection.close();
		return accounts;
	}

	public void save(Account account) throws SQLException {
		String query="insert into account(name,isactive,city,country,balance,emailaddress) values(?,?,?,?,?,?)";
		Connection connection=dataSource.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setString(1, account.getName());
		preparedStatement.setBoolean(2, account.isActive());
		preparedStatement.setString(3, account.getAddress().getCity());
		preparedStatement.setString(4, account.getAddress().getCountry());
		preparedStatement.setInt(5, account.getBalance());
		preparedStatement.setString(6, account.getEmailAddress());
		preparedStatement.executeUpdate();
		
		System.out.println("Account saved");
		

	
	}

	public void update(Account account) throws SQLException {
		String query="update account set name=?,isactive=?,city=?,country=?,balance=?,emailaddress=? where accountnumber=?";
		Connection connection=dataSource.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setString(1, account.getName());
		preparedStatement.setBoolean(2, account.isActive());
		preparedStatement.setString(3, account.getAddress().getCity());
		preparedStatement.setString(4, account.getAddress().getCountry());
		preparedStatement.setInt(5, account.getBalance());
		preparedStatement.setString(6, account.getEmailAddress());
		preparedStatement.setLong(7, account.getAccountNumber());
		preparedStatement.executeUpdate();
		System.out.println("Account updated");
	}

	public void delete(Account account) throws SQLException {
		String query="delete from  account a where  a.accountnumber=?";
		Connection connection=dataSource.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setLong(1, account.getAccountNumber());
		preparedStatement.executeUpdate();
		System.out.println("Account Deleted");
	
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	

}
