package cn.sanlijiankang.idGenerator.Controller;

import cn.sanlijiankang.idGenerator.Service.UidService;
import com.robert.vesta.service.bean.Id;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xxeNt
 * On 2020-04-22
 * Description:
 */
@Api(tags = "Uid控制器")
@RestController
public class UidController {
    @Autowired
    private UidService uidService;

    @ApiOperation(value = "生成uid", notes = "生成uid")
    @GetMapping("/genId")
    public long genId() {
        return uidService.genId();
    }

    @ApiOperation(value = "反解uid", notes = "反解uid")
    @PostMapping("/expId")
    public Id explainId(@RequestParam(value = "id", defaultValue = "0") long id) {
        return uidService.explainId(id);
    }

    @ApiOperation(value = "转换时间格式", notes = "转换时间格式")
    @PostMapping("/transTime")
    public String transTime(@RequestParam(value = "time", defaultValue = "-1") long time) {
        return uidService.transTime(time);
    }

    @ApiOperation(value = "根据入参生成uid", notes = "根据入参生成uid")
    @PostMapping("/makeId")
    public long makeId(@RequestParam(value = "version", defaultValue = "-1") long version,
                       @RequestParam(value = "type", defaultValue = "-1") long type,
                       @RequestParam(value = "genMethod", defaultValue = "-1") long genMethod,
                       @RequestParam(value = "machine", defaultValue = "-1") long machine,
                       @RequestParam(value = "time", defaultValue = "-1") long time,
                       @RequestParam(value = "seq", defaultValue = "-1") long seq) {
        return uidService.makeId(version, type, genMethod, machine, time, seq);
    }
}
