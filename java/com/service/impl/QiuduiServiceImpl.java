package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.QiuduiDao;
import com.entity.QiuduiEntity;
import com.service.QiuduiService;
import com.entity.view.QiuduiView;

/**
 * 球队信息 服务实现类
 * @since 2021-03-22
 */
@Service("qiuduiService")
@Transactional
public class QiuduiServiceImpl extends ServiceImpl<QiuduiDao, QiuduiEntity> implements QiuduiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<QiuduiView> page =new Query<QiuduiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
