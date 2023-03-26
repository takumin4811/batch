package com.example.webbatch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//import jp.co.nri.tstar.com.lib.logic.SimeSyriKankyoHensuGetUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebbatchApplication {	

	// private static final String PROPERTY_FILE_NAME = "application-sime.properties";
	
	public static void main(String[] args) throws IOException {
		// setJVMEnv();
		// Properties properties = new Properties();
		// try (InputStream in = WebbatchApplication.class.getClassLoader().getResourceAsStream(PROPERTY_FILE_NAME);) {
		// 	// プロパティファイルロード
		// 	properties.load(in);
		// }
		
		SpringApplication.run(WebbatchApplication.class, args);
	}

    private static void setJVMEnv() {
        // 環境変数設定処理
        List<String> kankyoHensuMeiList = new ArrayList<>();
        // // 利用会社コード
        // kankyoHensuMeiList.add("DD_USER");
        // // 起動ID
        // kankyoHensuMeiList.add("DD_KIDOUID");
        // // 基準日
        // kankyoHensuMeiList.add("DD_KJN");
        // // 実行処理ID
        // kankyoHensuMeiList.add("DD_EXECID");
        // バッチログファイル保存パス
        kankyoHensuMeiList.add("APL_LOG_K_DIR");
        // TEMPファイル保存パス
        kankyoHensuMeiList.add("APL_TMP_K_DIR");
        // 一日ファイル保存パス
        kankyoHensuMeiList.add("APL_DAT_K_DIR");
        // 累積ファイル保存パス
        kankyoHensuMeiList.add("APL_TRN_K_DIR");
        // 長期ファイル保存パス
        kankyoHensuMeiList.add("APL_DATEFILE_DIR");
        // Oracle設定ファイルパスTEMP
        kankyoHensuMeiList.add("ORACLE_NET_TNS_ADMIN");
        // BLグループ
        kankyoHensuMeiList.add("BL_GROUP");
        // プロパティファイル保存パス
        kankyoHensuMeiList.add("LOCAL_APL_JAVA_BT_PROP");

        // 締処理用環境変数取得SimeSyriKankyoHensuGetUtilの環境変数取得getKankyoHensuメソッドを呼び出す
        //kankyoHensuMap = SimeSyriKankyoHensuGetUtil.getKankyoHensu(kankyoHensuMeiList);

        // Oracle設定ファイルパス設定
        //System.setProperty("oracle.net.tns_admin", kankyoHensuMap.get("ORACLE_NET_TNS_ADMIN"));
	}
}
