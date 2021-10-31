package com.way2learnonline.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.way2learnonline.model.Reward;


@Component
public class JdbcRewardRepositoryImpl implements RewardRepository {
	
	@Autowired
	private DataSource dataSource;
	
	public JdbcRewardRepositoryImpl() {
		
	}
	
	

	public JdbcRewardRepositoryImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public void addReward(Reward reward) throws SQLException {
		String query="insert into Reward(rewardAmount,accountNumber) values(?,?)";
		Connection connection=dataSource.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1, reward.getRewardAmount());
		preparedStatement.setLong(2, reward.getAccountNumber());
		
		preparedStatement.executeUpdate();

	}

	public int getTotalRewardAmount(Long accountNumber) {
		
		return 0;
	}

	public List<Reward> getAllRewardsForAccount(Long accountNUmber) {
		
		return null;
	}

}
