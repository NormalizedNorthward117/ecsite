package jp.co.internous.ecsite.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.internous.ecsite.model.entity.GOODS;

//全商品をGOODSクラスを介してgoodsテーブルを検索する
public interface GoodsRepository extends JpaRepository<GOODS, Long> {
	
}