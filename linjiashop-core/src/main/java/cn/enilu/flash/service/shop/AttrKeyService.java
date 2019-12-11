package cn.enilu.flash.service.shop;


import cn.enilu.flash.bean.entity.shop.AttrKey;
import cn.enilu.flash.bean.vo.query.SearchFilter;
import cn.enilu.flash.dao.shop.AttrKeyRepository;
import cn.enilu.flash.service.BaseService;
import cn.enilu.flash.utils.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttrKeyService extends BaseService<AttrKey,Long, AttrKeyRepository>  {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private AttrKeyRepository attrKeyRepository;

    public List<AttrKey> queryBy(Long idCategory, Long idGoods){
        return queryAll(Lists.newArrayList(
                SearchFilter.build("idCategory",idCategory),
                SearchFilter.build("idGoods",idGoods, SearchFilter.Join.or)
        ));
    }

}

