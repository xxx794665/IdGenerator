package cn.sanlijiankang.idGenerator.Service;

import com.robert.vesta.service.bean.Id;
import com.robert.vesta.service.intf.IdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xxeNt
 * On 2020-04-22
 * Description:Uid生成器Service
 */
@Service
public class UidService {
    @Resource
    private IdService idService;

    //生成uid
    public long genId() {
        return idService.genId();
    }

    //反解uid
    public Id explainId(long id) {
        return idService.expId(id);
    }

    //转换可读时间格式
    public String transTime(long time) {
        return idService.transTime(time).toString();
    }

    //自定义uid
    public long makeId(long version, long type, long genMethod, long machine, long time, long seq) {
        long madeId = -1;
        if (time == -1 || seq == -1)
            throw new IllegalArgumentException("Both time and seq are required!");
        else if (version == -1) {
            if (type == -1) {
                if (genMethod == -1) {
                    if (machine == -1) {
                        madeId = idService.makeId(time, seq);
                    } else {
                        madeId = idService.makeId(machine, time, seq);
                    }
                } else {
                    madeId = idService.makeId(genMethod, machine, time, seq);
                }
            } else {
                madeId = idService.makeId(type, genMethod, machine, time, seq);
            }
        } else {
            madeId = idService.makeId(version, type, genMethod, machine, time, seq);
        }

        return madeId;
    }
}
