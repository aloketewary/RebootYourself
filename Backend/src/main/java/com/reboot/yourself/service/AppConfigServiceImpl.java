package com.reboot.yourself.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reboot.yourself.dao.AppConfigDAO;
import com.reboot.yourself.model.ApplicationConfiguration;

@Service
public class AppConfigServiceImpl implements AppConfigService{

	@Autowired
	AppConfigDAO appConfigDAO;

	@Override
	public Map<String,String> getConfigList() {
		// TODO Auto-generated method stub
		List<ApplicationConfiguration> appConfigList =  new ArrayList<>();
		Map<String,String> appConfifMap = new HashMap<>();
		appConfigList = appConfigDAO.getConfigList();
		if(appConfigList != null && !appConfigList.isEmpty()) {
			for(ApplicationConfiguration appConfg : appConfigList) {
				appConfifMap.put(appConfg.getKey(), appConfg.getValue());
			}
		}	
		return appConfifMap;
	}
	
}
