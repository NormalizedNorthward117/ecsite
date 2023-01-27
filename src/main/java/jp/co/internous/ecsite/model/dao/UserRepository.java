package jp.co.internous.ecsite.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.internous.ecsite.model.entity.USER;

//LoginFormクラスから渡されるuserName、passWordを条件にDB内を検索するDAO
//USERクラスを介してuserテーブルを検索する
public interface UserRepository extends JpaRepository<USER, Long> {
	
	List<USER> findByUSERNAMEAndPASSWORD(String User_Name, String Pass_Word);
	
}
