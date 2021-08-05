package com.li88qq.service.serviceImpl;

import com.li88qq.service.repo.LoginLogRepo;
import com.li88qq.service.request.log.GetLoginPageBo;
import com.li88qq.service.response.GetLoginPageVo;
import com.li88qq.service.service.ILogService;
import com.li88qq.service.utils.DateUtil;
import com.li88qq.service.utils.SessionUtil;
import com.li88qq.service.utils.StringUtil;
import org.fastquery.page.Page;
import org.fastquery.page.Pageable;
import org.fastquery.page.PageableImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Map;

/**
 * 记录
 *
 * @author li88qq
 * @version 1.0 2021/8/5 22:08
 */
@Service
public class LogService implements ILogService {

    @Resource
    private LoginLogRepo loginLogRepo;

    /**
     * 分页查询登录记录
     *
     * @param bo
     * @return
     */
    @Override
    public Page<GetLoginPageVo> getLoginPage(GetLoginPageBo bo) {
        String loginIp = bo.getLoginIp();
        LocalDate beginDate = bo.getBeginDate();
        LocalDate endDate = bo.getEndDate();

        loginIp = StringUtil.like(loginIp);
        Long beginDateLong = DateUtil.getQuery(beginDate, true);
        Long endDateLong = DateUtil.getQuery(endDate, false);

        Long uid = SessionUtil.getUid();
        Pageable pageable = new PageableImpl(bo.getPage(), bo.getSize());
        Page<Map<String, Object>> pageData = loginLogRepo.getPage(uid, bo.getState(), bo.getLoginType(), beginDateLong, endDateLong, loginIp, pageable);

        return pageData.convert(GetLoginPageVo.class);
    }
}
