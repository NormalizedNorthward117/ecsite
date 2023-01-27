package jp.co.internous.ecsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.internous.ecsite.model.dao.GoodsRepository;
import jp.co.internous.ecsite.model.dao.UserRepository;
import jp.co.internous.ecsite.model.entity.GOODS;
import jp.co.internous.ecsite.model.entity.USER;
import jp.co.internous.ecsite.model.form.GoodsForm;
import jp.co.internous.ecsite.model.form.LoginForm;

//主に画面遷移を担うControllerクラス
//対応するフロントエンド.htmlと交互に作成して動作・表示を確認
@Controller
@RequestMapping("/ecsite/admin")
// http://localhost:8080/ecsite/adminにアクセス時
public class AdminController {
	
//UserRepositoryインターフェースの読み込み
	@Autowired
	private UserRepository userRepos;

//GoodsRepositoryインターフェースの読み込み
	@Autowired
	private GoodsRepository goodsRepos;
	
// http://localhost:8080/ecsite/admin/にアクセス時
	@RequestMapping("/")
	public String index() {
		return "adminindex";
	}
		
	@PostMapping("/welcome")
	public String welcome(LoginForm form, Model m) {
		
		List<USER> users = userRepos.findByUSERNAMEAndPASSWORD( form.getUserName(), form.getPassWord() );
		
	//検索結果が存在した時、
		if(users != null && users.size() > 0 ) {
			
		//管理者かどうか(isAdminカラムの値≠0か)の確認変数
			boolean isAdmin = users.get(0).getISADMIN() != 0;
		
		//管理者である(isAdminカラムの値≠0)時
			if(isAdmin) {
				
				List<GOODS> goods = goodsRepos.findAll();
				
				m.addAttribute( "userName", users.get(0).getUSERNAME() );
				m.addAttribute( "passWord", users.get(0).getPASSWORD() );
				
				m.addAttribute("goods", goods);
			}
			
		}
		
		return "welcome";
	}
	
//新商品登録へ移動
	@RequestMapping("/goodsMst")
	public String goodsMst(LoginForm form, Model m) {
		
		m.addAttribute("userName", form.getUserName() );
		m.addAttribute("passWord", form.getPassWord() );
		
		return "goodsmst";
	}

//新商品新規登録反映
	@RequestMapping("/addGoods")
	public String addGoods(GoodsForm goodsform, LoginForm loginform, Model m ) {
		
		m.addAttribute("userName", loginform.getUserName() );
		m.addAttribute("passWord", loginform.getPassWord() );
		
		GOODS goods = new GOODS();
		
		goods.setGOODSNAME( goodsform.getGoodsName() );
		goods.setPRICE( goodsform.getPrice() );
		
		goodsRepos.saveAndFlush(goods);
		
		return "forward:/ecsite/admin/welcome";
	}
	
//商品削除機能　RESTと呼ばれるajaxを使用した方式
	@ResponseBody
	@PostMapping("/api/deleteGoods")
	public String deleteApi( @RequestBody GoodsForm gf, Model m) {
		
		try {
			goodsRepos.deleteById( gf.getId() );
			
		} catch (IllegalArgumentException e ) {
			return "-1";
			
		}
		
		return "1";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
