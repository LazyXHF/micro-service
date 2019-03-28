package com.portjs.base.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.portjs.base.aop.LogInfo;
import com.portjs.base.dao.BanGongManagerDao;
import com.portjs.base.dao.TDepartmentMapper;
import com.portjs.base.dao.TXietongSuppliesRepositoryMapper;
import com.portjs.base.entity.*;
import com.portjs.base.service.BanGongManagerService;
import com.portjs.base.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ruanshuhao on 2018/12/20.
 */


@Controller
@CrossOrigin
@RequestMapping("/bangong")
@org.springframework.transaction.annotation.Transactional
public class BanGongManagerController extends BaseController {
    ResponseMessage responseMessage = null;
    private String tag = "BanGongManagerController()=============>";


    @Autowired
    BanGongManagerService banGongService;
    @Autowired
    TDepartmentMapper departmentMapper;
    @Autowired
    UserInfoUtil userInfoUtil;
    @Autowired
    BanGongManagerDao banGongManagerDao;
    @Autowired
    TXietongSuppliesRepositoryMapper suppliesRepositoryMapper;
    @Autowired
    DaibanUtil daibanUtil;
    @Autowired
    private Upload upload;
   /* @Autowired
    AesEncryptUtils aesEncryptUtils;
    private static final String KEY = "abcdef0123456789";*/

    //待办事项 区别不同用户
    @LogInfo(methodName = "待办类别")
    @RequestMapping("queryTypeApply")
    @ResponseBody
    public ResponseMessage queryTypeApply(@RequestBody String requestBody) {
        logger.debug(tag + "queryTypeApply()  begin");
        JSONObject requestJson = JSONObject.parseObject(requestBody);
        String ownerId = requestJson.getString("ownerId");
        Long bangongId = banGongService.queryBanGongId();
        String bangongId1 = String.valueOf(bangongId);
        Long repositoryId = banGongService.queryRepositoryId();
        String repositoryId1 = String.valueOf(repositoryId);
        Long pucharseId = banGongService.queryPucharseId();
        String pucharseId1 = String.valueOf(pucharseId);
        //0:办公室 用品审批 1：仓管员：用品发放 2：采购员：采购申请  3代表普通用户
        if (repositoryId1.equals(ownerId)) {
            return new ResponseMessage(Code.CODE_OK, "用品发放", 1);
        } else if (ownerId.equals(pucharseId1)) {
            return new ResponseMessage(Code.CODE_OK, "采购申请", 2);
        } else {
            return new ResponseMessage(Code.CODE_OK, "用品审批", 0);
        }
        /*else {
            return new ResponseMessage(Code.CODE_OK, "其他用户", 3);
        }*/
    }

    ///判断当前登录人
    @LogInfo(methodName = "判断登录人")
    @RequestMapping("isOfficer")
    @ResponseBody
    public ResponseMessage isOfficer(@RequestBody String requestBody) {
        logger.debug(tag + "queryTypeApply()  begin");
        JSONObject requestJson = JSONObject.parseObject(requestBody);
        String ownerId = requestJson.getString("ownerId");
        Long Officer = banGongService.queryBanGongId();
        String Officer1 = Officer.toString();
        if (ownerId.equals(Officer1)) {
            //1:代表当 前登录人是办公室
            return new ResponseMessage(Code.CODE_OK, "当前人是办公室", "1");
        } else {
            return new ResponseMessage(Code.CODE_OK, "当期登录人不是办公室", "2");
        }
    }

    /*
        //忠烈下拉框
        @LogInfo(methodName = "类型")
        @RequestMapping("queryCategory")
        @ResponseBody
        public ResponseMessage queryCategory() {
            logger.debug(tag + "queryCategory()  begin");
            try {
                List<TXietongSuppliesRepository> list = banGongService.queryCategory();
                responseMessage = new ResponseMessage(Code.CODE_OK, "办公用品名称", list);
                return new ResponseMessage(Code.CODE_OK, "办公用品名称", list);
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("querySupplyName() error", e);
                return responseMessage = new ResponseMessage(Code.CODE_ERROR, "服务器错误", e);
            }

        }
    */
    //办公用品下拉框
    @LogInfo(methodName = "类型")
    @RequestMapping("queryCategories")
    @ResponseBody
    public ResponseMessage queryCategories() {
        logger.debug(tag + "queryCategories()  begin");
        try {
            List<TXietongSuppliesCategory> list = banGongService.queryCategories();
            responseMessage = new ResponseMessage(Code.CODE_OK, "类型", list);
            return new ResponseMessage(Code.CODE_OK, "类型", list);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("querySupplyName() error", e);
            return responseMessage = new ResponseMessage(Code.CODE_ERROR, "服务器错误", e);
        }
    }
    //办公用品搜索框下拉框
    @LogInfo(methodName = "类型")
    @RequestMapping("querySupplyCategories")
    @ResponseBody
    public ResponseMessage querySupplyCategories() {
        logger.debug(tag + "querySupplyCategories()  begin");
        try {
            List<TXietongSuppliesCategory> list = banGongService.querySupplyCategories();
            responseMessage = new ResponseMessage(Code.CODE_OK, "类型", list);
            return new ResponseMessage(Code.CODE_OK, "类型", list);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("querySupplyName() error", e);
            return responseMessage = new ResponseMessage(Code.CODE_ERROR, "服务器错误", e);
        }
    }

    //办公用品下拉框
    @LogInfo(methodName = "用品名称")
    @RequestMapping("querySupplyName")
    @ResponseBody
    public ResponseMessage querySupplyName(@RequestBody String requestBody) {
        logger.debug(tag + "querySupplyName()  begin");
        try {
            JSONObject requestJson = JSONObject.parseObject(requestBody);
            String categoryId = requestJson.getString("categoryId");
            List<TXietongSuppliesRepository> list = banGongService.querySupplyName(categoryId);
            responseMessage = new ResponseMessage(Code.CODE_OK, "办公用品名称", list);
            return new ResponseMessage(Code.CODE_OK, "办公用品名称", list);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("querySupplyName() error", e);
            return responseMessage = new ResponseMessage(Code.CODE_ERROR, "服务器错误", e);
        }

    }
    //查询规格型号
    @LogInfo(methodName = "规格型号")
    @RequestMapping("querySupplyType")
    @ResponseBody
    public ResponseMessage querySupplyType(@RequestBody String requestBody) {
        logger.debug(tag + "querySupplyType() begin...requestBody=", requestBody);
        try {
            JSONObject requestJson = JSONObject.parseObject(requestBody);
            Integer id = requestJson.getInteger("id");
            List<TXietongSuppliesRepository> list = banGongService.querySupplyType(id);
            responseMessage = new ResponseMessage(Code.CODE_OK, "办公用品名称", list);
        } catch (Exception e) {
            logger.error(tag + "querySupplyType() ereor...=", e);
            return responseMessage = new ResponseMessage(Code.CODE_ERROR, "服务器错误", e);
        }
        return responseMessage;
    }
    //查询办公室审核人
    @LogInfo(methodName = "办公审核人")
    @RequestMapping("/queryApplyPeoples")
    @ResponseBody
    public ResponseMessage queryApplyPeoples() {
        logger.debug(tag + "queryApplyPeoples() begin");
        try {
            List<TXietongDictionary> applyPeoples = banGongService.queryApplyPeople();
            responseMessage = new ResponseMessage(Code.CODE_OK, "办公用品审核人列表", applyPeoples);
        } catch (Exception e) {
            logger.error(tag + "queryApplyPeoples()" + e);
            return responseMessage = new ResponseMessage(Code.CODE_ERROR, "服务器错误", e);
        }
        return responseMessage;
    }

    //办公用品下拉框
    @LogInfo(methodName = "部门下拉框")
    @RequestMapping("queryDepartMentName")
    @ResponseBody
    public ResponseMessage queryDepartMentName() {
        logger.debug(tag + "queryDepartMentName()");
        try {
            List<TDepartment> list = departmentMapper.findAllDepartment();
            responseMessage = new ResponseMessage(Code.CODE_OK, "办公用品名称", list);
        } catch (Exception e) {
            responseMessage = new ResponseMessage(Code.CODE_ERROR, "服务器异常" + e);
            logger.error("queryDepartMentName() error..." + e);
            return responseMessage;
        }
        return responseMessage;
    }
    /**
     *  添加办公用品
     */
    @LogInfo(methodName = "添加办公用品")
    @RequestMapping("/add")
    @ResponseBody
    public ResponseMessage addBanGong(@RequestBody String requestBody) {
        logger.debug(tag + "addBanGong() begin...requestBody", requestBody);
        try {
            ResponseMessage message;
            JSONObject requestJson = JSONObject.parseObject(requestBody);
            String name = requestJson.getString("name");
            String nameid = requestJson.getString("nameid");
            String type = requestJson.getString("type");
            String typeid = requestJson.getString("typeid");
            String price = requestJson.getString("price");
            Integer stock = requestJson.getInteger("stock");
            String reamark = requestJson.getString("reamark");
            String category = requestJson.getString("category");
            String categoryId = requestJson.getString("categoryId");
            String encode = requestJson.getString("encode");
            Integer attribute = requestJson.getInteger("attribute");
            String filePath = requestJson.getString("filePath");
            TXietongSupplies supplies = new TXietongSupplies();
            supplies.setId(UUID.randomUUID().toString());
            supplies.setName(name);
            supplies.setType(type);
            supplies.setPrice(price);
            supplies.setStock(stock);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            Date time = null;
            try {
                time = sdf.parse(sdf.format(new Date()));
            } catch (Exception e) {
                logger.error("转换时间格式出错", e);
                e.printStackTrace();
                message = new ResponseMessage(Code.CODE_ERROR, "时间转换错误");
                return message;
            }
            supplies.setCreatetime(time);
            supplies.setIsdelete(0);
        /*supplies.setTotalnumber("null");*/
            supplies.setReamark(reamark);
            supplies.setNameId(nameid);
            supplies.setTypeId(typeid);
            supplies.setCategory(category);
            supplies.setCategoryId(categoryId);
            supplies.setAttribute(attribute);
            if (!encode.equals("")) {
                supplies.setEncode(encode);
            } else {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH) + 1;
                int day = cal.get(Calendar.DATE);//获取日
                int hour = cal.get(Calendar.HOUR_OF_DAY);
                int minute = cal.get(Calendar.MINUTE);
                int second = cal.get(Calendar.SECOND);
                String time2 = year + "" + month + day + hour + minute + second;
                supplies.setEncode(time2);
            }
            supplies.setFilePath(filePath);
            TXietongSupplies ts = banGongManagerDao.selectRight(name, type);
            if (ts != null) {
                return new ResponseMessage(Code.CODE_ERROR, "物品已经存在，请点击编辑");
            } else {
                int flag = banGongService.addBanGong(supplies);
                if (flag == 1) {
                    return new ResponseMessage(Code.CODE_OK, "办公用品添加成功");
                }
            }
            return new ResponseMessage(Code.CODE_ERROR, "办公用品添加失败");

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(tag + "updateDepartmentNameByName() error..." + e);
            return new ResponseMessage(Code.CODE_ERROR, "服务器异常", e);
        }
    }

    //新增办公用品名称
    @LogInfo(methodName = "添加类型")
    @RequestMapping("/addCategory")
    @ResponseBody
    public ResponseMessage addCategory(@RequestBody String requestBody) {
        logger.debug(tag + "addCategory() begin....requestBody", requestBody);
        try {
            JSONObject requestJson = JSONObject.parseObject(requestBody);
            String id = UUID.randomUUID().toString();
            String category = requestJson.getString("category");
            if (category.isEmpty()) {
                return new ResponseMessage(Code.CODE_ERROR, "类型不能为空");
            }
            int count = banGongService.queryCategory(category);
            if (count == 0) {
                int flag = banGongService.addCategory(id, category);
                if (flag == 1) {
                    return new ResponseMessage(Code.CODE_OK, "类型添加成功");
                } else {
                    return new ResponseMessage(Code.CODE_ERROR, "类型添加失败");
                }
            } else {
                return new ResponseMessage(Code.CODE_ERROR, "类型已经存在");
            }
        } catch (Exception e) {
            logger.error(tag + "addBanGongName() error...=", e);
            return responseMessage = new ResponseMessage(Code.CODE_ERROR, "服务器错误" + e);
        }
    }

    //新增办公用品名称
    @LogInfo(methodName = "添加办公用品名称")
    @RequestMapping("/addName")
    @ResponseBody
    public ResponseMessage addBanGongName(@RequestBody String requestBody) {
        logger.debug(tag + "addBanGongName() begin....requestBody", requestBody);
        try {
            JSONObject requestJson = JSONObject.parseObject(requestBody);
            //这里的id是类型的id
            String categoryId = requestJson.getString("id");
            String name = requestJson.getString("name");
            if (name.isEmpty()) {
                return new ResponseMessage(Code.CODE_ERROR, "用品，名称不能为空");
            }
            //只要这个名称已经存在  无论在哪个类别下都不允许添加
            int count = banGongService.queryChongFu(categoryId, name);
            if (count == 0) {
                int flag = banGongService.addBanGongName(name, categoryId);
                if (flag == 1) {
                    return new ResponseMessage(Code.CODE_OK, "办公用品名称添加成功");
                } else {
                    return new ResponseMessage(Code.CODE_ERROR, "办公用品型号添加失败");
                }
            } else {

                return new ResponseMessage(Code.CODE_ERROR, "用品名称已经存在");
            }
        } catch (Exception e) {
            logger.error(tag + "addBanGongName() error...=", e);
            return responseMessage = new ResponseMessage(Code.CODE_ERROR, "服务器错误" + e);
        }
    }
  //添加办公用品类型
    @LogInfo(methodName = "添加办公用品类型")
    @RequestMapping("/addType")
    @ResponseBody
    public ResponseMessage addBanGongType(@RequestBody String requestBody) {
        logger.debug(tag + "addBanGongName()");
        JSONObject requestJson = JSONObject.parseObject(requestBody);
        Integer id = requestJson.getInteger("id");
        String type = requestJson.getString("type");
        int amount = suppliesRepositoryMapper.queryType(type, id);
        if (amount != 0) {
            return new ResponseMessage(Code.CODE_ERROR, "该物品下该型号已经存在");
        }
        int flag = banGongService.addBanGongType(type, id);
        if (flag == 1) {
            return new ResponseMessage(Code.CODE_OK, "办公用品类型添加成功");
        }
        return new ResponseMessage(Code.CODE_ERROR, "办公用品类型添加失败");
    }
/*
         暂时不用了
    @LogInfo(methodName = "添加办公用品类型和类型")
    @RequestMapping("/addNameAndType")
    @ResponseBody
    public ResponseMessage addNameAndType(@RequestBody String requestBody) {
        logger.debug(tag + "addNameAndType() begin ... requestBody", requestBody);
        try {
            JSONObject requestJson = JSONObject.parseObject(requestBody);
            String Name = requestJson.getString("Name");
            if (Name == null) {
                return new ResponseMessage(Code.CODE_ERROR, "用品名不能为空");
            }
            String Type = requestJson.getString("Type");
            int count = banGongService.queryChongFu(Name);
       *//* int count2 = banGongService.queryChongFuType(Type);*//*
            //名称一样  判断类型是否相同  如果有：返回  没有：添加类型
            if (count != 0) {
                int typeId = suppliesRepositoryMapper.queryTypeId(Name);
                //根据条件看能否查到
                int amount = suppliesRepositoryMapper.queryType(Type, typeId);
                //不为0  说明这个名称下面这个类型已经有了  则返回
                if (amount != 0) {
                    return new ResponseMessage(Code.CODE_ERROR, "该类型该名称已经存在");
                    //名称一样  但是该类型没有  添加类型
                } else {
                    int flag2 = banGongService.addBanGongType(Type, typeId);
                    if (flag2 != 1) {
                        return new ResponseMessage(Code.CODE_ERROR, "用品类型添加失败");
                    }
                }
                //名称不一样   直接添加该类型 和 该名称
            } else {
                int flag = banGongService.addBanGongName(Name);
                if (flag != 1) {
                    return new ResponseMessage(Code.CODE_ERROR, "办公用品添加失败");
                }
                int typeId = suppliesRepositoryMapper.queryTypeId(Name);
                int flag2 = banGongService.addBanGongType(Type, typeId);
                if (flag2 != 1) {
                    return new ResponseMessage(Code.CODE_ERROR, "办公用品类型添加失败");
                }
            }
            return new ResponseMessage(Code.CODE_OK, "添加类型和名称成功");
        } catch (Exception e) {
            logger.error(tag + "addNameAndType() error...=", e);
            return new ResponseMessage(Code.CODE_ERROR, "服务器异常", e);
        }
    }*/

    /**
     *  TODO 查询办公用品信息  用品申领 和  用品库存查询都是使用这个接口
     */
    @LogInfo(methodName = "查询办公用品信息")
    @RequestMapping(value = "/queryBanGong")
    @ResponseBody
    public ResponseMessage queryBanGong(@RequestBody String requestBody) {
        logger.debug(tag + " " + "queryBanGong() begin ...requestBody", requestBody);
        try {
            JSONObject requestJson = JSONObject.parseObject(requestBody);
            //新需求把类型去掉了 这里不用修改代码
         /*String typeId = requestJson.getString("typeId");
         String nameId = requestJson.getString("nameId");*/
            String content = requestJson.getString("content");
            String category = requestJson.getString("category");
            String pageNum = requestJson.getString("pageNum");
            String pageCount = requestJson.getString("pageCount");
            String ownerId = requestJson.getString("ownerId");
            String repositoryId = banGongService.queryRepositoryId().toString();
            if (ownerId.equals(repositoryId)) {
                Page<TXietongSupplies> page = new Page<>();
                int totalCount = banGongService.getCount(content, category);
                page.init(totalCount, Integer.valueOf(pageNum), Integer.valueOf(pageCount));
                logger.debug("page={}", page.toString());
                List<TXietongSupplies> list = banGongService.getSupplies(content, category, page.getRowNum(), page.getPageCount());
                page.setList(list);
                return new ResponseMessage(Code.CODE_OK, "分页成功", page);
            } else {
                Page<TXietongSupplies> page = new Page<>();
                int totalCount = banGongService.getCount1(content, category);
                page.init(totalCount, Integer.valueOf(pageNum), Integer.valueOf(pageCount));
                logger.debug("page={}", page.toString());
                List<TXietongSupplies> list = banGongService.getSupplies1(content, category, page.getRowNum(), page.getPageCount());
                page.setList(list);
                return new ResponseMessage(Code.CODE_OK, "分页成功", page);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(tag + "queryBanGong() error...=" + e);
            responseMessage = new ResponseMessage(Code.CODE_ERROR, "服务器异常" + e);
            return responseMessage;

        }
    }

    @SuppressWarnings("Duplicates")
    @LogInfo(methodName = "编辑办公用品信息")
    @RequestMapping(value = "/updateBanGong")
    @ResponseBody
    //注意在更新的时候 由于数据库id为String，这里存的是uuid，到时候需要再进行修改
    public ResponseMessage updateBanGong(@RequestBody String requestBody) {
        logger.debug(tag + "updateBanGong() begin...parent_id=", requestBody);
        try {
            JSONObject requestJson = JSONObject.parseObject(requestBody);
            String id = requestJson.getString("id");
            String name = requestJson.getString("name");

            String type = requestJson.getString("type");

            String price = requestJson.getString("price");
            Integer stock = requestJson.getInteger("stock");
            String reamark = requestJson.getString("reamark");
            //2.20碰撞新增字段
            String category = requestJson.getString("category");
            String categoryId = UUID.randomUUID().toString();
            Integer attribute = requestJson.getInteger("attribute");
            String encode = requestJson.getString("encode");
            String filePath = requestJson.getString("filePath");
            TXietongSupplies supplies = new TXietongSupplies();
            supplies.setId(id);
            supplies.setName(name);
            supplies.setType(type);
            supplies.setPrice(price);
            supplies.setStock(stock);
            supplies.setIsdelete(0);
            supplies.setReamark(reamark);
            supplies.setCategory(category);
            supplies.setCategoryId(categoryId);
            supplies.setAttribute(attribute);
            supplies.setEncode(encode);
            supplies.setFilePath(filePath);
            //这个Id1是表里的id  用来判断是否是当前记录
            String id1 = banGongService.querySupplyId(category, name, type);
            //是当前记录   进行更新
            if (id1 != null) {
                if (id1.equals(id)) {
                    int flag = banGongService.updateBanGong(supplies);
                    if (flag != 1) {
                        return new ResponseMessage(Code.CODE_ERROR, "修改失败");
                    }
                    return new ResponseMessage(Code.CODE_OK, "修改成功");
                }
                //id不同  不是同一条记录  不允许修改
                else {
                    return new ResponseMessage(Code.CODE_ERROR, "该类型和名称已经存在");
                }
            }
            //id1为空 说明修改过
            //库里没有分为两种情况  1名称和类型都没有  2：名称有 类型没有  判断类型是否已经存在
            else {
                // -----------------------------------在编辑的时候进行下拉框的更改---------------------------------------------
                TXietongSuppliesCategory category1 = banGongService.queryCategoryClass(category);
                TXietongSuppliesRepository repository = banGongService.queryRepository(name);
                //查询出来为空说明种类库里没有
                if (category1 == null) {
                    //将新的种类添加进进去
                    String categoryid2 = UUID.randomUUID().toString();
                    int f = banGongService.insertCategory(categoryid2, category);
                    if (f != 1) {
                        return new ResponseMessage(Code.CODE_ERROR, "添加类别失败");
                    }
                    //如果repository为空  说明这个用品不存在
                    if (repository == null) {
                        int f1 = banGongService.insertSupply(name, categoryid2);
                        if (f1 != 1) {
                            return new ResponseMessage(Code.CODE_ERROR, "添加名称失败");
                        }
                        int typeId = banGongService.queryNameId(name, categoryid2);
                        int f2 = banGongService.insertType(type, typeId);
                        if (f2 != 1) {
                            return new ResponseMessage(Code.CODE_ERROR, "添加类别失败");
                        }
                    }
                    //  该种类没有   但是该名称已经存在   更新该用品到新的类别 判断有没有该类别；
                    else {

                        int f3 = banGongService.updateRepository(name, categoryid2);
                        if (f3 != 1) {
                            return new ResponseMessage(Code.CODE_ERROR, "更新种类失败");
                        }
                        int typeId = banGongService.queryNameId(name, categoryid2);
                        int num = banGongService.queryRepositoryType(type, typeId);
                        //如果没有该类别   添加
                        if (num == 0) {
                            int f4 = banGongService.insertType(type, typeId);
                            if (f4 != 1) {
                                return new ResponseMessage(Code.CODE_ERROR, "添加类别失败");
                            }
                        }
                        //有该类别 不做任何操作
                     /* else{
                          banGongService.updateRepositoryType(type,typeId);
                      }*/
                    }
                }
                //种类不为空
                else {
                    String category1Id = category1.getId();
                    //类别已经存在  用品名称为空
                    if (repository == null) {
                        //先插入名称  和对应的种类id；
                        int f5 = banGongService.insertSupply(name, category1Id);
                        if (f5 != 1) {
                            return new ResponseMessage(Code.CODE_ERROR, "添加类别失败");
                        }
                        //再插入对应的类别；
                        int typeId = banGongService.queryNameId(name, category1Id);
                        int f6 = banGongService.insertType(type, typeId);
                        if (f6 != 1) {
                            return new ResponseMessage(Code.CODE_ERROR, "添加用品类别失败");
                        }
                    }
                    //如果repository不为空   说明这个种类已经有了  用品名称也有  但是没有该类别
                    //如果类别有 种类也有 分两种   该类别下有  该类别下没有
                    else {
                       int f= banGongService.queryCategorySupply(category1.getId(),repository.getName());
                       //查询出来该类别下  该名称没有 将已经有的名称修改在该类别下面
                       if(f==0){
                            banGongService.updateRepository(repository.getName(), category1.getId());
                            //种类会自动修改
                        }
                        //该类别下  该名称已经有  分两种  该种类有   该种类没有
                        else{
                           int typeid = repository.getId();
                           int num = banGongService.queryRepositoryType(type, typeid);
                           //类别有  用品名称有  类别没有  添加类别
                           if (num == 0) {
                               banGongService.insertType(type, typeid);
                           }/*else{
                           banGongService.updateRepositoryType(type,typeid);
                       }*/

                       }

                    }
                }
                //  -----------------------------------在编辑的时候进行下拉框的更改---------------------------------------------
                int flag = banGongService.updateBanGong(supplies);
                if (flag != 1) {
                    return new ResponseMessage(Code.CODE_OK, "修改失败");
                }
                return new ResponseMessage(Code.CODE_OK, "修改成功");
            }
        } catch (Exception e) {
            logger.error("updateBanGong() error..." + e);
            e.printStackTrace();
            responseMessage = new ResponseMessage(Code.CODE_ERROR, "服务器异常" + e);
            return responseMessage;

        }
    }
    /**
     *  TODO 申领办公用品
     * @param requestBody
     * @return
     */
    @LogInfo(methodName = "用品申领")
    @RequestMapping(value = "/applySupply")
    @ResponseBody
    public ResponseMessage applySupply(@RequestBody String requestBody) {
        logger.debug(tag + " applySupply() begin...requestBody", requestBody);
        try {
            JSONObject requestJson = JSONObject.parseObject(requestBody);
            int code = 1;
            //物品名称id
            String supplyId = requestJson.getString("supplyId");
            //申请物品名称
            String supplyName = requestJson.getString("supplyName");
            String supplyType = requestJson.getString("supplyType");
            String applyDepId = requestJson.getString("applyDepId");
            String applyDepName = requestJson.getString("applyDepName");
            String applyId = requestJson.getString("applyId");
            String applyName = requestJson.getString("applyName");
            Integer applyCount = requestJson.getInteger("applyCount");
            Integer stocks = requestJson.getInteger("stock");
            String user = requestJson.getString("user");
            String userId = requestJson.getString("userId");
            String category = requestJson.getString("category");
            String categoryId = requestJson.getString("categoryId");
            String content = requestJson.getString("content");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            Date time = null;
            try {
                time = sdf.parse(sdf.format(new Date()));
            } catch (Exception e) {
                logger.debug("转换时间格式出错", e);
                e.printStackTrace();
                return new ResponseMessage(Code.CODE_ERROR, "时间转换错误");
            }
            TXietongSuppliesApply suppliesApply = new TXietongSuppliesApply();
            suppliesApply.setId(UUID.randomUUID().toString());
            //记录未审批 状态为1
            suppliesApply.setStatus("1");
            suppliesApply.setIsdelete(0);
            suppliesApply.setCreatetime(time);
            String ownerId1 = requestJson.getString("ownerId");
            Map<String, String> map = userInfoUtil.getUserInfo(ownerId1);
            String nextApprover = map.get("userName");
            suppliesApply.setNextApprover(nextApprover);
            suppliesApply.setNextApproverId(ownerId1);
            // 当这条记录被同意了再设置endtime
            // suppliesApply.setEndtime();
            suppliesApply.setSupplyType(supplyType);
            suppliesApply.setSupplyId(supplyId);
            //申请人的ID;

            suppliesApply.setApplyId(applyId);
            suppliesApply.setApplyName(applyName);
            suppliesApply.setApplyDepId(applyDepName);
            suppliesApply.setApplyDepName(applyDepName);
            suppliesApply.setApplyCount(applyCount);
            suppliesApply.setContent(content);
            //暂不传值
            //suppliesApply.setNextRecordsIds("ids");
            suppliesApply.setSupplyName(supplyName);
            suppliesApply.setRequestType("1");
            suppliesApply.setBstatus("0");
            suppliesApply.setRstatus("1");
            suppliesApply.setPstatus("用品申请为空");
            suppliesApply.setUser(user);
            suppliesApply.setUserId(userId);
            suppliesApply.setCategory(category);
            suppliesApply.setCategoryId(categoryId);
            if (applyCount > stocks) {
               /*申请的数量大于库存的数量  ，所以需要转采购流程  给予一个状态码*/
                code = 0;
            }
            suppliesApply.setCode(code);
            TXietongSuppliesApplyRecord applyRecord = new TXietongSuppliesApplyRecord();
            //指定的办公室审核人的id
            String ownerId = requestJson.getString("ownerId");
            applyRecord.setId(UUID.randomUUID().toString());
            applyRecord.setApplyId(suppliesApply.getId());
            applyRecord.setOwnerId(ownerId);
            applyRecord.setCreatetime(suppliesApply.getCreatetime());
            applyRecord.setIsdelete(0);
            applyRecord.setStatus(0);
            applyRecord.setIsRead(0);
            //setApplyType 1 代表 用品发放
            applyRecord.setApplyType(1);
            applyRecord.setIscc(applyCount);
            int f = banGongService.addApplyRecords(applyRecord);
            if (f != 1) {
                return new ResponseMessage(Code.CODE_ERROR, "后台指定审核人出现错误");
            }
            //生成通知
            daibanUtil.insertDaibanRecord(applyRecord.getId(), content, "bgyp0", applyRecord.getOwnerId());

            int flag = banGongService.addSuppliedApply(suppliesApply);
            if (flag == 1) {
                return new ResponseMessage(Code.CODE_OK, "申请添加成功");
            }
            return new ResponseMessage(Code.CODE_ERROR, "申领添加失败");
        } catch (Exception e) {
            logger.error(tag + "applySupply() error...=" + e);
            e.printStackTrace();
            responseMessage = new ResponseMessage(Code.CODE_ERROR, "服务器异常" + e);
            return responseMessage;
        }
    }

    //申领其他办公用品
    @LogInfo(methodName = "其他用品申领")
    @RequestMapping(value = "/applySupplyOther")
    @ResponseBody
    public ResponseMessage applySupplyOther(@RequestBody String requestBody) {
        logger.debug(tag + " applySupplyOther() begin...requestBody", requestBody);
        try {
            JSONObject requestJson = JSONObject.parseObject(requestBody);
            //申请物品名称
            int code;
            String supplyName = requestJson.getString("supplyName");
            String supplyType = requestJson.getString("supplyType");
            String applyDepId = requestJson.getString("applyDepId");
            String applyDepName = requestJson.getString("applyDepName");
            String applyId = requestJson.getString("applyId");
            String applyName = requestJson.getString("applyName");
            Integer applyCount = requestJson.getInteger("applyCount");
            Integer stocks = requestJson.getInteger("stock");
            String user = requestJson.getString("user");
            String userId = requestJson.getString("userId");
            String category = requestJson.getString("category");
            String categoryId = requestJson.getString("categoryId");
            int num = banGongService.querySupplyByName(supplyName, supplyType);
            if (num != 0) {
                return new ResponseMessage(Code.CODE_ERROR, "该物品仓库已经存在");
            } else {
                code = 0;
            }
            String content = requestJson.getString("content");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            Date time = null;
            try {
                time = sdf.parse(sdf.format(new Date()));
            } catch (Exception e) {
                logger.debug("转换时间格式出错", e);
                e.printStackTrace();
                return new ResponseMessage(Code.CODE_ERROR, "时间转换错误");
            }
            TXietongSuppliesApply suppliesApply = new TXietongSuppliesApply();
            suppliesApply.setId(UUID.randomUUID().toString());
            //记录未审批 状态为1
            suppliesApply.setStatus("1");
            suppliesApply.setIsdelete(0);
            suppliesApply.setCreatetime(time);
            String ownerId1 = requestJson.getString("ownerId");
            Map<String, String> map = userInfoUtil.getUserInfo(ownerId1);
            String nextApprover = map.get("userName");
            suppliesApply.setNextApprover(nextApprover);
            suppliesApply.setNextApproverId(ownerId1);
           /* 当这条记录被同意了再设置endtime*/
            /*suppliesApply.setEndtime();*/
            suppliesApply.setSupplyType(supplyType);
            //申请人的ID;
            suppliesApply.setApplyId(applyId);
            suppliesApply.setApplyName(applyName);
            suppliesApply.setApplyDepId(applyDepName);
            suppliesApply.setApplyDepName(applyDepName);
            suppliesApply.setApplyCount(applyCount);
            suppliesApply.setContent(content);
            //暂不传值
            /*suppliesApply.setNextRecordsIds("ids");*/
            suppliesApply.setSupplyName(supplyName);
            suppliesApply.setRequestType("1");
            suppliesApply.setBstatus("0");
            suppliesApply.setRstatus("1");
            suppliesApply.setPstatus("用品申请为空");
            suppliesApply.setUser(user);
            suppliesApply.setUserId(userId);
            suppliesApply.setCategory(category);
            suppliesApply.setCategoryId(categoryId);
            suppliesApply.setCode(code);
            TXietongSuppliesApplyRecord applyRecord = new TXietongSuppliesApplyRecord();
            //指定的办公室审核人的id
            /*long id= banGongService.queryRepositoryId();*/
            String ownerId = requestJson.getString("ownerId");
            applyRecord.setId(UUID.randomUUID().toString());
            applyRecord.setApplyId(suppliesApply.getId());
            applyRecord.setOwnerId(ownerId);
            applyRecord.setCreatetime(suppliesApply.getCreatetime());
            applyRecord.setIsdelete(0);
            applyRecord.setStatus(0);
            applyRecord.setIsRead(0);
            //setApplyType 1 代表 用品发放
            applyRecord.setApplyType(1);
            applyRecord.setIscc(applyCount);
            int f = banGongService.addApplyRecords(applyRecord);
            if (f != 1) {
                return new ResponseMessage(Code.CODE_ERROR, "后台指定审核人出现错误");
            }
            //生成通知
            daibanUtil.insertDaibanRecord(applyRecord.getId(), content, "bgyp0", applyRecord.getOwnerId());
            int flag = banGongService.addSuppliedApply(suppliesApply);
            if (flag == 1) {
                return new ResponseMessage(Code.CODE_OK, "申请添加成功");
            }
            return new ResponseMessage(Code.CODE_ERROR, "申领添加失败");
        } catch (Exception e) {
            logger.error(tag + "applySupply() error...=" + e);
            e.printStackTrace();
            responseMessage = new ResponseMessage(Code.CODE_ERROR, "服务器异常" + e);
            return responseMessage;
        }
    }
        /*注意这里还是可以指定多个审核人*/
    /*    JSONArray jsonArray = requestJson.getJSONArray("Approver");
        for (int i = 0; i < jsonArray.size(); i++) {
            TXietongSuppliesApplyRecord applyRecord = new TXietongSuppliesApplyRecord();
            applyRecord.setId(UUID.randomUUID().toString());
            applyRecord.setApplyId(suppliesApply.getId());
            JSONObject jo = jsonArray.getJSONObject(i);
            //这里的ownerid是指定的多个审核人的id
            String ownerId = jo.getString("ownerId");
            applyRecord.setOwnerId(ownerId);
            applyRecord.setCreatetime(suppliesApply.getCreatetime());
            applyRecord.setIsdelete(0);
            applyRecord.setStatus(0);
            applyRecord.setIsRead(0);
                    *//*主送和抄送*//*
                    *//*applyRecord.setIscc();*//*
            //创建者的id也就是申请人的id
            applyRecord.setCreatorId(suppliesApply.getApplyId());
            applyRecord.setCreatorName(suppliesApply.getApplyName());
            int f = banGongService.addApplyRecords(applyRecord);
            if (f != 1) {
                return new ResponseMessage(Code.CODE_ERROR, "指定审核人失败");
            }
        }*/
    /**
     * TODO 采购员查询采购申请
     * @param requestBody
     * @return
     */
    @LogInfo(methodName = "用品申请审批查询")
    @RequestMapping(value = "/handleApply")
    @ResponseBody
    public ResponseMessage handleApply(@RequestBody String requestBody) {
        logger.debug(tag + "handleApply() begin...requestBody", requestBody);
        try {
            JSONObject requestJson = JSONObject.parseObject(requestBody);
            String supplyName = requestJson.getString("supplyName");
            String supplyId = requestJson.getString("supplyId");
            String applyName = requestJson.getString("applyName");
            String ownerId = requestJson.getString("ownerId");
            String applyId = requestJson.getString("applyId");
            String pageNum = requestJson.getString("pageNum");
            String pageCount = requestJson.getString("pageCount");
            Page<TXietongSuppliesApply> page = new Page<>();
            int count = banGongService.selectCountAll(supplyName, applyName, ownerId);
            page.init(count, Integer.valueOf(pageNum), Integer.valueOf(pageCount));

            List<TXietongSuppliesApply> list = banGongService.selectAll(supplyName, applyName, ownerId, page.getRowNum(), page.getPageCount());
            if (list.size() != 0) {
                for (TXietongSuppliesApply suppliesApply : list) {
                    String supplyId1 = suppliesApply.getSupplyId();
                    String supplyType1 = suppliesApply.getSupplyType();
                    int stock = banGongService.queryStock(supplyId1, supplyType1);
                    suppliesApply.setStock(stock);
                    int officerStstus = banGongService.queryStatus(suppliesApply.getId(), ownerId);
                    suppliesApply.setOfficerStatus(officerStstus);
                }
            }
            page.setList(list);
            page.setTypeApply(0);
            return new ResponseMessage(Code.CODE_OK, "分页信息", page);
         /*   List<TXietongSuppliesApplyRecord> suppliesApplyRecords = banGongService.querySupplyApplyRecord(ownerId);
            Page<TXietongSuppliesApply> page = new Page<>();
            page.init(suppliesApplyRecords.size(), Integer.valueOf(pageNum), Integer.valueOf(pageCount));

            List<TXietongSuppliesApplyRecord> list2 = banGongService.querySupplyApplyRecord2(ownerId,page.getRowNum(), page.getPageCount());

            List<TXietongSuppliesApply> list=new ArrayList<>();

            for (TXietongSuppliesApplyRecord applyRecord : list2) {
                String ID = applyRecord.getApplyId();
                //int totalNumber = banGongService.getApplyCount(supplyName, applyName, ID);
                TXietongSuppliesApply suppliesApply= banGongService.queryApplying(supplyName, applyName, ID, page.getRowNum(), page.getPageCount());
                   int officerStstus=banGongService.queryStatus(suppliesApply.getId(),ownerId);
                    String supplyId1 = suppliesApply.getSupplyId();
                    String supplyType1 = suppliesApply.getSupplyType();
                    int stock = banGongService.queryStock(supplyId1, supplyType1);
                    suppliesApply.setStock(stock);
                    suppliesApply.setOfficerStatus(officerStstus);
                    list.add(suppliesApply);
            }
            page.setList(list);
            page.setTypeApply(0);*/

          /*  Long bangongshiId=banGongService.queryBanGongId();
           String  bangongshiId1=bangongshiId.toString();
           //如果是办公室  查询所有的
           if(bangongshiId1.equals(ownerId)){
               Page<TXietongSuppliesApply> page = new Page<>();
               int totalNumber = banGongService.getApplyCount2(supplyName, applyName, ownerId);
               page.init(totalNumber, Integer.valueOf(pageNum), Integer.valueOf(pageCount));
               List<TXietongSuppliesApply> list = banGongService.queryApplying2(supplyName, applyName, ownerId, page.getRowNum(), page.getPageCount());
               for (TXietongSuppliesApply suppliesApply : list) {
                   String supplyId1 = suppliesApply.getSupplyId();
                   String supplyType1 = suppliesApply.getSupplyType();
                   int stock = banGongService.queryStock(supplyId1, supplyType1);
                   suppliesApply.setStock(stock);
               }
               page.setList(list);
               page.setTypeApply(0);
               return new ResponseMessage(Code.CODE_OK, "分页信息", page);
           }else {
               Page<TXietongSuppliesApply> page = new Page<>();
               int totalNumber = banGongService.getApplyCount(supplyName, applyName, ownerId);
               page.init(totalNumber, Integer.valueOf(pageNum), Integer.valueOf(pageCount));
               List<TXietongSuppliesApply> list = banGongService.queryApplying(supplyName, applyName, ownerId, page.getRowNum(), page.getPageCount());
               //修改的新街口
               /*//*   List<TXietongSuppliesApply> list = banGongService.queryApplying1(supplyName, applyName, ownerId);*//**//*
               for (TXietongSuppliesApply suppliesApply : list) {
                   String supplyId1 = suppliesApply.getSupplyId();
                   String supplyType1 = suppliesApply.getSupplyType();
                   int stock = banGongService.queryStock(supplyId1, supplyType1);
                   suppliesApply.setStock(stock);
               }
               page.setList(list);
               page.setTypeApply(0);
               return new ResponseMessage(Code.CODE_OK, "分页信息", page);
           }*/
        } catch (Exception e) {
            logger.debug(tag + "handleApply() error...=", e);
            return responseMessage = new ResponseMessage(Code.CODE_ERROR, "服务器异常" + e);
        }
    }

    //待办事项用品审批
    @LogInfo(methodName = "用品申请审批查询")
    @RequestMapping(value = "/handleApply1")
    @ResponseBody
    public ResponseMessage handleApply1(@RequestBody String requestBody) {
        logger.debug(tag + "handleApply1() begin...requestBody", requestBody);
        try {
            JSONObject requestJson = JSONObject.parseObject(requestBody);
            String supplyName = requestJson.getString("supplyName");
            String supplyId = requestJson.getString("supplyId");
            String applyName = requestJson.getString("applyName");
            String ownerId = requestJson.getString("ownerId");
            String applyId = requestJson.getString("applyId");
            String pageNum = requestJson.getString("pageNum");
            String pageCount = requestJson.getString("pageCount");

            Page<TXietongSuppliesApply> page = new Page<>();
            int count = banGongService.selectCountAllDaiBan(supplyName, applyName, ownerId);
            page.init(count, Integer.valueOf(pageNum), Integer.valueOf(pageCount));
            List<TXietongSuppliesApply> list = banGongService.selectAllDaiBan(supplyName, applyName, ownerId, page.getRowNum(), page.getPageCount());
            if (list != null) {
                for (TXietongSuppliesApply suppliesApply : list) {
                    String supplyId1 = suppliesApply.getSupplyId();
                    String supplyType1 = suppliesApply.getSupplyType();
                    int stock = banGongService.queryStock(supplyId1, supplyType1);
                    suppliesApply.setStock(stock);
                    int officerStstus = banGongService.queryStatus(suppliesApply.getId(), ownerId);
                    suppliesApply.setOfficerStatus(officerStstus);
                }
            }
            page.setList(list);
            page.setTypeApply(0);
            return new ResponseMessage(Code.CODE_OK, "分页信息", page);


       /*     Page<TXietongSuppliesApply> page = new Page<>();
            int count =banGongService.selectCountAll(supplyName,applyName,ownerId);
            page.init(count, Integer.valueOf(pageNum), Integer.valueOf(pageCount));

            List<TXietongSuppliesApply> list= banGongService.selectAll(supplyName,applyName,ownerId,page.getRowNum(), page.getPageCount());
            for (TXietongSuppliesApply suppliesApply : list) {
                String supplyId1 = suppliesApply.getSupplyId();
                String supplyType1 = suppliesApply.getSupplyType();
                int stock = banGongService.queryStock(supplyId1, supplyType1);
                suppliesApply.setStock(stock);
            }
            page.setList(list);
            page.setTypeApply(0);
            return new ResponseMessage(Code.CODE_OK, "分页信息", page);


            Long bangongshiId=banGongService.queryBanGongId();
            String  bangongshiId1=bangongshiId.toString();
            List<TXietongSuppliesApplyRecord> suppliesApplyRecords = banGongService.querySupplyApplyRecord(ownerId);
            Page<TXietongSuppliesApply> page = new Page<>();
            page.init(suppliesApplyRecords.size(), Integer.valueOf(pageNum), Integer.valueOf(pageCount));

            List<TXietongSuppliesApplyRecord> list2 = banGongService.querySupplyApplyRecord2(ownerId,page.getRowNum(), page.getPageCount());

            List<TXietongSuppliesApply> list=new ArrayList<>();

            for (TXietongSuppliesApplyRecord applyRecord : list2) {
                String ID = applyRecord.getApplyId();
                //int totalNumber = banGongService.getApplyCount(supplyName, applyName, ID);
                TXietongSuppliesApply suppliesApply= banGongService.queryApplyingDaiBan(supplyName, applyName, ID, page.getRowNum(), page.getPageCount());
                int officerStstus=banGongService.queryStatus(suppliesApply.getId(),ownerId);
                String supplyId1 = suppliesApply.getSupplyId();
                String supplyType1 = suppliesApply.getSupplyType();
                int stock = banGongService.queryStock(supplyId1, supplyType1);
                suppliesApply.setStock(stock);
                suppliesApply.setOfficerStatus(officerStstus);
                list.add(suppliesApply);
            }
            page.setList(list);
            page.setTypeApply(0);
            return new ResponseMessage(Code.CODE_OK, "分页信息", page);*/
         /*   //如果是办公室  查询所有的
            if(bangongshiId1.equals(ownerId)){
                Page<TXietongSuppliesApply> page = new Page<>();
                int totalNumber = banGongService.getApplyCountDaiBan2(supplyName, applyName, ownerId);
                page.init(totalNumber, Integer.valueOf(pageNum), Integer.valueOf(pageCount));
                List<TXietongSuppliesApply> list = banGongService.queryApplyingDaiBan2(supplyName, applyName, ownerId, page.getRowNum(), page.getPageCount());
                for (TXietongSuppliesApply suppliesApply : list) {
                    String supplyId1 = suppliesApply.getSupplyId();
                    String supplyType1 = suppliesApply.getSupplyType();
                    int stock = banGongService.queryStock(supplyId1, supplyType1);
                    suppliesApply.setStock(stock);
                }
                page.setList(list);
                page.setTypeApply(0);
                return new ResponseMessage(Code.CODE_OK, "分页信息", page);
            }else {
                Page<TXietongSuppliesApply> page = new Page<>();
                int totalNumber = banGongService.getApplyCountDaiBan(supplyName, applyName, ownerId);
                page.init(totalNumber, Integer.valueOf(pageNum), Integer.valueOf(pageCount));
                List<TXietongSuppliesApply> list = banGongService.queryApplyingDaiBan(supplyName, applyName, ownerId, page.getRowNum(), page.getPageCount());
                for (TXietongSuppliesApply suppliesApply : list) {
                    String supplyId1 = suppliesApply.getSupplyId();
                    String supplyType1 = suppliesApply.getSupplyType();
                    int stock = banGongService.queryStock(supplyId1, supplyType1);
                    suppliesApply.setStock(stock);
                }
                page.setList(list);
                page.setTypeApply(0);
                return new ResponseMessage(Code.CODE_OK, "分页信息", page);
            }*/
        } catch (Exception e) {
            logger.debug(tag + "handleApply() error...=", e);
            return responseMessage = new ResponseMessage(Code.CODE_ERROR, "服务器异常" + e);
        }
    }

    @LogInfo(methodName = "用品申请审批")
    @RequestMapping(value = "/handle")
    @ResponseBody
    public ResponseMessage handle(@RequestBody String requestBody) {
        logger.debug(tag + "handle() begin...requestBody=", requestBody);
        try {
            JSONObject requestJson = JSONObject.parseObject(requestBody);
            //这个id是申请表的主id，记录表的applyid
            String applyId = requestJson.getString("id");
            String recComment = requestJson.getString("recCooment");
            String supplyId = requestJson.getString("supplyId");
            String supplyType = requestJson.getString("supplyType");
            Integer amount = requestJson.getInteger("amount");
            //这是这条记录发起人的id
            String creatorName = requestJson.getString("createorName");
            String creatorId = requestJson.getString("creatorId");
            //这里的ownerid是当前登录人的id;办公室主任id
            String ownerId = requestJson.getString("ownerId");
            Map<String, String> map1 = userInfoUtil.getUserInfo(ownerId);
            String depname = map1.get("deptmentName");
            Integer opinion = requestJson.getInteger("opinion");

            //===========================新增的数据=======================
            String supplyName = requestJson.getString("supplyName");
            String content = requestJson.getString("content");
            String requestType = banGongService.queryRequestType(applyId);
            TXietongSuppliesApplyRecord applyRecords = new TXietongSuppliesApplyRecord();
            applyRecords.setApplyId(applyId);
            applyRecords.setOwnerId(ownerId);
            applyRecords.setDepartName(depname);
            applyRecords.setRecComment(recComment);
            applyRecords.setStatus(1);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            Date time = null;
            try {
                time = sdf.parse(sdf.format(new Date()));
            } catch (Exception e) {
                logger.debug("转换时间格式出错", e);
                e.printStackTrace();
                return new ResponseMessage(Code.CODE_ERROR, "时间转换错误");
            }
            applyRecords.setDealTime(time);
            applyRecords.setIsRead(1);
            //查询的从表的Id
            String id = banGongService.queryRecordIdBanGong(applyId, ownerId);
            applyRecords.setId(id);
            //1代表拒绝
            if (opinion == 1) {
                //------------------------关于库存 等后续管理员进行处理-------------------------------------
                applyRecords.setOpinion(opinion);
                //原来是根据主表id和当前登陆人进行修改  考虑一人多身份   用唯一从表Id进行修改
                int flag = banGongService.updateapplyRecord(applyRecords);
              /*  int flag = banGongService.updateapplyRecordById(id);*/
                if (flag != 1) {
                    return new ResponseMessage(Code.CODE_ERROR, "审批失败");
                }
                JSONArray jsonArray = requestJson.getJSONArray("Redirector");
                if (jsonArray.size() != 0) {
                    for (int i = 0; i < jsonArray.size(); i++) {
                        JSONObject jo = jsonArray.getJSONObject(i);
                        TXietongSuppliesApplyRecord toRepository = new TXietongSuppliesApplyRecord();
                        String repositoryManId = jo.getString("redirectorManId");
                        String repositoryManName = jo.getString("redirectorManName");
                        toRepository.setId(UUID.randomUUID().toString());
                        toRepository.setApplyId(applyId);
                        toRepository.setOwnerId(repositoryManId);
                        toRepository.setOwnerName(repositoryManName);
                        toRepository.setRecComment(recComment);
                        toRepository.setCreatetime(time);
                        toRepository.setIsdelete(0);
                        toRepository.setStatus(0);
                        Map<String, String> map = userInfoUtil.getUserInfo(ownerId);
                        toRepository.setCreatorName(map.get("userName"));
                   /* String recdepname = map1.get("deptmentName");*/
                        toRepository.setCreatorId(ownerId);
                        toRepository.setOpinion(opinion);
                        toRepository.setDepartName(depname);
                        if (requestType.equals("1")) {
                            //设置为1  代表用品发放
                            toRepository.setApplyType(1);
                        } else if (requestType.equals("2")) {
                            toRepository.setApplyType(2);
                        }
                        int ff = banGongService.addApplyRecords(toRepository);
                        if (ff != 1) {
                            return new ResponseMessage(Code.CODE_ERROR, "审批信息发送仓库管理员失败");
                        }
                    }
                }

                daibanUtil.UpdateDaibanRecord(id);
              /*  return new ResponseMessage(Code.CODE_OK, "审批成功");*/
                /*办公室同意*/
            } else {
                /*------------------指定仓库管理员--------------*/
                applyRecords.setOpinion(opinion);
                int flag = banGongService.updateapplyRecord(applyRecords);
                if (flag != 1) {
                    return new ResponseMessage(Code.CODE_ERROR, "审批失败");
                }
                JSONArray jsonArray = requestJson.getJSONArray("Redirector");
                if (jsonArray.size() != 0) {
                    for (int i = 0; i < jsonArray.size(); i++) {
                        JSONObject jo = jsonArray.getJSONObject(i);
                        TXietongSuppliesApplyRecord toRepository = new TXietongSuppliesApplyRecord();
                        String repositoryManId = jo.getString("redirectorManId");
                        String repositoryManName = jo.getString("redirectorManName");
                        toRepository.setId(UUID.randomUUID().toString());
                        toRepository.setApplyId(applyId);
                        toRepository.setOwnerId(repositoryManId);
                        toRepository.setOwnerName(repositoryManName);
                        toRepository.setRecComment(recComment);
                        toRepository.setCreatetime(time);
                        toRepository.setIsdelete(0);
                        toRepository.setStatus(0);
                        Map<String, String> map = userInfoUtil.getUserInfo(ownerId);
                        toRepository.setCreatorName(map.get("userName"));
                        String recdepname = map1.get("deptmentName");
                        toRepository.setCreatorId(ownerId);
                        toRepository.setOpinion(opinion);
                        toRepository.setDepartName(depname);
                        //暂时将申请数量放入无用字段iscc中
                        toRepository.setIscc(amount);
                        if (requestType.equals("1")) {
                            //设置为1  代表用品发放
                            toRepository.setApplyType(1);
                        } else if (requestType.equals("2")) {
                            toRepository.setApplyType(2);
                        }
                        int ff = banGongService.addApplyRecords(toRepository);
                        if (ff != 1) {
                            return new ResponseMessage(Code.CODE_ERROR, "审批信息发送仓库管理失败");
                        }
                        //生成通知
                        Long bangongId = banGongService.queryBanGongId();
                        String bangongId1 = String.valueOf(bangongId);
                        Long repositoryId = banGongService.queryRepositoryId();
                        String repositoryId1 = String.valueOf(repositoryId);
                        Long pucharseId = banGongService.queryPucharseId();
                        String pucharseId1 = String.valueOf(pucharseId);
                        if (repositoryManId.equals(repositoryId1)) {
                            daibanUtil.insertDaibanRecord(toRepository.getId(), recComment, "bgyp1", toRepository.getOwnerId());
                        } else if (repositoryManId.equals(pucharseId1)) {
                            daibanUtil.insertDaibanRecord(toRepository.getId(), recComment, "bgyp2", toRepository.getOwnerId());
                        }
                    }
                }
                daibanUtil.UpdateDaibanRecord(id);
            }
            String bstatus = "1";
            int ff = banGongService.updateBnGongshiStatus(applyId, bstatus);
            if (ff != 1) {
                return new ResponseMessage(Code.CODE_ERROR, "更新办公室审批状态失败");
            }
            return new ResponseMessage(Code.CODE_OK, "审批成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(tag + "handle() error..." + e);
            return new ResponseMessage(Code.CODE_ERROR, "服务器异常", e);
        }
    }

    //============申领详情===============
    @LogInfo(methodName = "查询申请")
    @RequestMapping(value = "/querySupplyApplying")
    @ResponseBody
    public ResponseMessage querySupplyApplying(@RequestBody String requestBody) {
        logger.debug(tag + "querySupplyApplying() begin...requestBody", requestBody);
        try {
            JSONObject requestJson = JSONObject.parseObject(requestBody);
            String ownerId = requestJson.getString("ownerId");
            String pageNum = requestJson.getString("pageNum");
            String pageCount = requestJson.getString("pageCount");
            Page<TXietongSuppliesApply> page = new Page<>();
            int totalCount = banGongService.getSupplyApplyingCount(ownerId);
            page.init(totalCount, Integer.valueOf(pageNum), Integer.valueOf(pageCount));
            logger.debug("page{}", page.toString());
            Long repositoryId = banGongService.queryRepositoryId();
            String repositoryId1 = String.valueOf(repositoryId);
            List<TXietongSuppliesApply> list = banGongService.querySupplyApplyingList(ownerId, repositoryId1, page.getRowNum(), page.getPageCount());
            if (CollectionUtils.isEmpty(list)) {
                return new ResponseMessage(Code.CODE_ERROR, "分页数据为空");
            }

           /* for(TXietongSuppliesApply apply:list){
                TXietongSuppliesApplyRecord suppliesApplyRecord=  banGongService.queryBanGongXiangqing(apply.getId(),bangongId1);
                apply.setOpinion(suppliesApplyRecord.getOpinion());
            }*/
            page.setList(list);
            return new ResponseMessage(Code.CODE_OK, "分页结果", page);
        } catch (Exception e) {
            logger.error(tag + "handle() error...=", e);
            return responseMessage = new ResponseMessage(Code.CODE_ERROR, "服务器异常" + e);
        }
    }

    //============仓库管理员申领详情===============
    @LogInfo(methodName = "仓库管理员申领详情")
    @RequestMapping(value = "/querySupplyApplyingRepository")
    @ResponseBody
    public ResponseMessage querySupplyApplyingRepository(@RequestBody String requestBody) {
        logger.debug(tag + "querySupplyApplying() begin...requestBody", requestBody);
        try {
            JSONObject requestJson = JSONObject.parseObject(requestBody);
            String ownerId = requestJson.getString("ownerId");
            String pageNum = requestJson.getString("pageNum");
            String pageCount = requestJson.getString("pageCount");
            Page<TXietongSuppliesApply> page = new Page<>();
            int totalCount = banGongService.getSupplyApplyingCount1(ownerId);
            page.init(totalCount, Integer.valueOf(pageNum), Integer.valueOf(pageCount));
            logger.debug("page{}", page.toString());
            List<TXietongSuppliesApply> list = banGongService.querySupplyApplyingRepository(ownerId, page.getRowNum(), page.getPageCount());
            if (CollectionUtils.isEmpty(list)) {
                return new ResponseMessage(Code.CODE_ERROR, "分页数据为空");
            }
            for (TXietongSuppliesApply suppliesApply : list) {
                Integer code = suppliesApply.getCode();
                if (code == 3) {
                    suppliesApply.setOpinion(0);
                } else {
                    String bangongshiId = suppliesApply.getNextApproverId();
                    String id = suppliesApply.getId();
                    Integer opinion = banGongService.queryOpinion(id, bangongshiId);
                    suppliesApply.setOpinion(opinion);
                }
            }
            page.setList(list);
            return new ResponseMessage(Code.CODE_OK, "分页结果", page);
        } catch (Exception e) {
            logger.error(tag + "querySupplyApplying() error...=", e);
            return responseMessage = new ResponseMessage(Code.CODE_ERROR, "服务器异常" + e);
        }
    }

    @LogInfo(methodName = "仓管员处理详情")
    @RequestMapping(value = "/queryRepositoryStatus")
    @ResponseBody
    public ResponseMessage queryRepositoryStatus(@RequestBody String requestBody) {
        logger.debug(tag + "queryRepositoryStatus() begin...requestBody", requestBody);
        try {
            JSONObject requestJson = JSONObject.parseObject(requestBody);
            /*
            这里没有分页
            String pageNum = requestJson.getString("pageNum");
            String pageCount = requestJson.getString("pageCount");
            */
            String id = requestJson.getString("id");
            Long repositoryId = banGongService.queryRepositoryId();
            String repositoryId1 = String.valueOf(repositoryId);
            TXietongSuppliesApplyRecord suppliesApplyRecord = banGongService.queryBanGongXiangqing1(id, repositoryId1);
            if (suppliesApplyRecord == null) {
                return new ResponseMessage(Code.CODE_ERROR, "数据为空");
            }
            return new ResponseMessage(Code.CODE_OK, "数据结果", suppliesApplyRecord);
        } catch (Exception e) {
            logger.error(tag + "queryRepositoryStatus()", e);
            e.printStackTrace();
            return responseMessage = new ResponseMessage(Code.CODE_ERROR, "服务器异常" + e);

        }
    }

    @LogInfo(methodName = "审批详情")
    @RequestMapping(value = "/queryhandleDetails")
    @ResponseBody
    public ResponseMessage queryhandleDetails(@RequestBody String requestBody) {
        logger.debug(tag + "querySupplyApplying() begin...requestBody", requestBody);
        try {
            JSONObject requestJson = JSONObject.parseObject(requestBody);
            /*
            这里没有分页
            String pageNum = requestJson.getString("pageNum");
            String pageCount = requestJson.getString("pageCount");
            */
            String id = requestJson.getString("id");
            Integer code = requestJson.getInteger("code");
            /* code为3 是办公室发过来的 */
            if (code == 3) {
                TXietongSuppliesApplyRecord supplies = new TXietongSuppliesApplyRecord();
                supplies.setOpinion(0);
                Long pucharseId = banGongService.queryPucharseId();
                String pucharseId1 = String.valueOf(pucharseId);
                Integer pucharseStatus = banGongService.queryPucharseStatus(id, pucharseId1);
                //这里可以为null;
                supplies.setPucharseStatus(pucharseStatus);
                if (supplies == null) {
                    return new ResponseMessage(Code.CODE_ERROR, "数据为空");
                }
                return new ResponseMessage(Code.CODE_OK, "数据结果", supplies);
            } else {
                //查询办公室意见  所以这里的ownerid要用办公室的id
                Long bangongId = banGongService.queryBanGongId();
                String bangongId1 = String.valueOf(bangongId);
                TXietongSuppliesApplyRecord suppliesApplyRecord = banGongService.queryBanGongXiangqing(id, bangongId1);
                Long pucharseId = banGongService.queryPucharseId();
                String pucharseId1 = String.valueOf(pucharseId);
                Integer pucharseStatus = banGongService.queryPucharseStatus(id, pucharseId1);
                /* 这里可以为null; */
                suppliesApplyRecord.setPucharseStatus(pucharseStatus);
                if (suppliesApplyRecord == null) {
                    return new ResponseMessage(Code.CODE_ERROR, "数据为空");
                }
                return new ResponseMessage(Code.CODE_OK, "数据结果", suppliesApplyRecord);
            }
        } catch (Exception e) {
            logger.error(tag + "handle()", e);
            e.printStackTrace();
            return responseMessage = new ResponseMessage(Code.CODE_ERROR, "服务器异常" + e);

        }
    }

    @LogInfo(methodName = "取消申请")
    @RequestMapping(value = "/consoleApplying")
    @ResponseBody
    public ResponseMessage consoleApplying(@RequestBody String requestBody) {
        logger.debug(tag + "consoleApplying() begin...requestBody", requestBody);
        try {
            JSONObject requestJson = JSONObject.parseObject(requestBody);
            /*
            这里没有分页
            String pageNum = requestJson.getString("pageNum");
            String pageCount = requestJson.getString("pageCount");
            */
            String id = requestJson.getString("id");

            /*
            Page<TXietongSuppliesApply> page = new Page<>();
            int totalCount=banGongService.getSupplyApplyingCount();
            page.init(totalCount,Integer.valueOf(pageNum),Integer.valueOf(pageCount));
            logger.debug("page{}",page.toString());
            */
            int flag = banGongService.consoleApplying(id);
            /*
            Integer amount = requestJson.getInteger("amount");
            String supplyId = requestJson.getString("supplyId");
            String supplyType = requestJson.getString("supplyType");
            int stock = banGongService.queryStock(supplyId, supplyType);
            int oldStock = stock + amount;
            int f2 = banGongService.updateSupplies(oldStock, supplyId, supplyType);
            int f3 = banGongService.deleteSupplyApplyRecords(id);
            */
            if (flag != 1) {
                return new ResponseMessage(Code.CODE_ERROR, "取消申请失败");
            }
            return new ResponseMessage(Code.CODE_OK, "取消申请成功");
        } catch (Exception e) {
            logger.error(tag + "consoleApplying() error..." + e);
            return responseMessage = new ResponseMessage(Code.CODE_ERROR, "服务器异常" + e);
        }
    }


    @LogInfo(methodName = "归档")
    @RequestMapping(value = "/updateFinally")
    @ResponseBody

    public ResponseMessage updateFinally(@RequestBody String requestBody) {
        logger.debug(tag + "updateFinally() begin...requestBody", requestBody);
        JSONObject requestJson = JSONObject.parseObject(requestBody);
        /*
        查询原表
        增加历史表数据
        主表将对应的库存进行修改
        */

        /* 这里的id为这条记录的id*/

        String id = requestJson.getString("id");
        TXietongSuppliesApply suppliesApply = banGongService.queryApplyById(id);
        suppliesApply.setStatus("2");
        int f = banGongService.insertHisApply(suppliesApply);
        if (f != 1) {
            return new ResponseMessage(Code.CODE_ERROR, "添加历史表失败");
        }
        int f1 = banGongService.deleteApplyById(id);
        if (f1 != 1) {
            return new ResponseMessage(Code.CODE_ERROR, "删除原表失败");
        }


        int flag = banGongService.updateSuppliesApply(id);
        if (flag != 1) {
            return new ResponseMessage(Code.CODE_ERROR, "归档原纪录失败");
        }
        /*
        ==============归档不再将数据放入record表里
        TXietongSupplyRecord supplyRecord=new TXietongSupplyRecord();
        supplyRecord.setId(UUID.randomUUID().toString());
        supplyRecord.setSupplyId(suppliesApply.getSupplyId());
        supplyRecord.setSupplyName(suppliesApply.getSupplyName());
        supplyRecord.setSupplyType(suppliesApply.getSupplyType());
        supplyRecord.setReceiptorId(suppliesApply.getApplyId());
        supplyRecord.setReceiptorDepartId(suppliesApply.getApplyDepId());
        supplyRecord.setReamark(suppliesApply.getContent());
        supplyRecord.setIsdelete(1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        Date time = null;
        try {
        time = sdf.parse(sdf.format(new Date()));
        } catch (Exception e) {
        logger.debug("转换时间格式出错", e);
        e.printStackTrace();
        return new ResponseMessage(Code.CODE_ERROR, "时间转换错误");
        }
        supplyRecord.setCreatetime(time);
        supplyRecord.setAmount(suppliesApply.getApplyCount());
        Map<String,String> map= userInfoUtil.getUserInfo();
        supplyRecord.setReceiptorName(map.get("userName"));
        supplyRecord.setReceiptorDepartName(map.get("deptmentName"));
        int f2=banGongService.addSupplyRecord(supplyRecord);
        if(f2!=1){
        return  new ResponseMessage(Code.CODE_ERROR,"新增申请记录失败");
        }
        */
        return new ResponseMessage(Code.CODE_OK, "归档成功");
    }


    @LogInfo(methodName = "根据用品名和类型查询申领明细")
    @RequestMapping(value = "/queryRecord")
    @ResponseBody
    public ResponseMessage queryRecord(@RequestBody String requestBody) {
        logger.debug(tag + "queryBanGongRecord() begin...requestBody", requestBody);
        try {
            JSONObject requestJson = JSONObject.parseObject(requestBody);
            String supplyId = requestJson.getString("supplyId");
            String supplyType = requestJson.getString("supplyType");
            /*
            String pageNum = requestJson.getString("pageNumber");
            String pageCount = requestJson.getString("pageCount");
            Page<TXietongSupplyRecord> page = new Page<>();
            int totalCount = banGongService.getRecordCount(supplyName, receiptorName);
            page.init(totalCount, Integer.valueOf(pageNum), Integer.valueOf(pageCount));
            logger.debug("page={}", page.toString());
            */
            List<TXietongSupplyRecord> list = banGongService.getSupplyRecord(supplyId, supplyType);
            if (CollectionUtils.isEmpty(list)) {
                return new ResponseMessage(Code.CODE_OK, "结果为空");
            }
            return new ResponseMessage(Code.CODE_OK, "查询信息", list);
        } catch (Exception e) {
            logger.error(tag + "queryRecord() error...=", e);
            e.printStackTrace();
            return new ResponseMessage(Code.CODE_ERROR, "服务器异常", e);
        }
    }

    /*   JSONArray jsonArray = requestJson.getJSONArray("Redirector");
       for (int i = 0; i < jsonArray.size(); i++) {
       TXietongSuppliesApplyRecord applyRecord = new TXietongSuppliesApplyRecord();
       applyRecord.setId(UUID.randomUUID().toString());
       applyRecord.setApplyId(applyId);
        JSONObject jo = jsonArray.getJSONObject(i);
        //这里的ownerid是指定的多个审核人的id
       String redirectorId = jo.getString("redirectorId");
       applyRecord.setOwnerId(redirectorId);
       applyRecord.setCreatetime(time);
       applyRecord.setIsdelete(0);
       applyRecord.setStatus(0);
       applyRecord.setIsRead(0);
    //创建者的id也就是申请人的id
      applyRecord.setCreatorId(suppliesApply.getApplyId());
       applyRecord.setCreatorName(suppliesApply.getApplyName());
       int f = banGongService.addApplyRecords(applyRecord);
       if (f != 1) {
           return new ResponseMessage(Code.CODE_ERROR, "指定审核人失败");
       }
    }*/
/*-----------------------------仓库管理员查询审批记录-----------------------------*/
    @LogInfo(methodName = "管理员办公室意见结果查询")
    @RequestMapping(value = "/queryResult")
    @ResponseBody
    public ResponseMessage queryResult(@RequestBody String requestBody) {
        logger.debug(tag + "queryResult() begin...requestBody", requestBody);
        try {
            JSONObject requestJson = JSONObject.parseObject(requestBody);
            String ownerId = requestJson.getString("ownerId");
            String supplyName = requestJson.getString("supplyName");
            String supplyType = requestJson.getString("supplyType");
            String pageNum = requestJson.getString("pageNumber");
            String pageCount = requestJson.getString("pageCount");
            Page<TXietongSuppliesApply> page = new Page<>();
            int totalCount = banGongService.queryResultCount(ownerId, supplyName, supplyType);
            page.init(totalCount, Integer.valueOf(pageNum), Integer.valueOf(pageCount));
            List<TXietongSuppliesApply> list = banGongService.queryResult(ownerId, supplyName, supplyType, page.getRowNum(), page.getPageCount());
            int amount;
            for(TXietongSuppliesApply suppliesApply:list){
                amount=banGongService.queryStock(suppliesApply.getSupplyName(),suppliesApply.getSupplyType());
                suppliesApply.setStock(amount);
            }
            page.setList(list);
            page.setTypeApply(1);
            if (list != null) {
                return new ResponseMessage(Code.CODE_OK, "分页信息", page);
            }
            return new ResponseMessage(Code.CODE_ERROR, "分页信息为空");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(tag + "queryResult() error..." + e);
            return new ResponseMessage(Code.CODE_ERROR, "服务器异常", e);
        }
    }

    @LogInfo(methodName = "管理员办公室意见结果查询")
    @RequestMapping(value = "/queryResult1")
    @ResponseBody
    public ResponseMessage queryResult1(@RequestBody String requestBody) {
        logger.debug(tag + "queryResult1() begin...requestBody", requestBody);

        JSONObject requestJson = JSONObject.parseObject(requestBody);
        String ownerId = requestJson.getString("ownerId");
        String supplyName = requestJson.getString("supplyName");
        String supplyType = requestJson.getString("supplyType");
        String pageNum = requestJson.getString("pageNumber");
        String pageCount = requestJson.getString("pageCount");
        Page<TXietongSuppliesApply> page = new Page<>();
        int totalCount = banGongService.queryResultCountDaiBan(ownerId, supplyName, supplyType);
        page.init(totalCount, Integer.valueOf(pageNum), Integer.valueOf(pageCount));
        List<TXietongSuppliesApply> list = banGongService.queryResultDaiBan(ownerId, supplyName, supplyType, page.getRowNum(), page.getPageCount());
        page.setList(list);
        page.setTypeApply(1);
        if (list != null) {
            return new ResponseMessage(Code.CODE_OK, "分页信息", page);
        }
        return new ResponseMessage(Code.CODE_ERROR, "分页信息为空");
      /*  }catch (Exception e){
            e.printStackTrace();
            logger.error(tag+"queryResult() error..." + e);
            return  new ResponseMessage(Code.CODE_ERROR,"服务器异常",e);
        }*/
    }

    //  -----------------------仓管管理----------------------------
    //管理员同意    进行库存减少操作 并且添加进入记录表  这里在处理的时候数量不应该是死的   万一出现库存不足的情况？
    @LogInfo(methodName = "仓管处理")
    @RequestMapping(value = "/handleResult")
    @ResponseBody
    public ResponseMessage handleResult(@RequestBody String requestBody) {
        logger.debug(tag + "handleResult() begin...requestBody", requestBody);
        try {
            JSONObject requestJson = JSONObject.parseObject(requestBody);
            //注意这里的数量是活的  是仓管确认后的
            Integer applyCount = requestJson.getInteger("applyCount");
            String supplyId = requestJson.getString("supplyId");
            String supplyName = requestJson.getString("supplyName");
            String supplyType = requestJson.getString("supplyType");
            String applyId = requestJson.getString("applyId");
            String applyName = requestJson.getString("applyName");
            String applyDepId = requestJson.getString("applyDepId");
            String applyDepName = requestJson.getString("applyDepName");
            String recComment = requestJson.getString("recCommnet");
            //这个ownerId是办公室处理人的id
            String ownerId = requestJson.getString("ownerId");
            String rstatus = "2";
            //当前记录的Id;
            String id = requestJson.getString("id");
            //当前处理人也就是仓库管理的Id；
            String repositoryId = requestJson.getString("repositoryId");
            Integer opinion = requestJson.getInteger("opinion");
            if (opinion == 1) {
                TXietongSuppliesApplyRecord applyRecords = new TXietongSuppliesApplyRecord();
                applyRecords.setApplyId(id);
                applyRecords.setOwnerId(repositoryId);
                applyRecords.setOpinion(opinion);
                applyRecords.setStatus(1);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
                Date time = null;
                try {
                    time = sdf.parse(sdf.format(new Date()));
                } catch (Exception e) {
                    logger.debug("转换时间格式出错", e);
                    e.printStackTrace();
                    return new ResponseMessage(Code.CODE_ERROR, "时间转换错误");
                }
                applyRecords.setDealTime(time);
                applyRecords.setIsRead(1);
                int flag = banGongService.updateapplyRecord1(applyRecords);
                if (flag != 1) {
                    return new ResponseMessage(Code.CODE_ERROR, "更新库存管理员状态失败");
                }
                int ffl = banGongService.updateRepositoryStatus(id, rstatus);
                //applytype为1 :用品发放
                String recordId = banGongService.queryRecordId(applyRecords.getApplyId(), applyRecords.getOwnerId());
                daibanUtil.UpdateDaibanRecord(recordId);
                if (ffl != 1) {
                    return new ResponseMessage(Code.CODE_ERROR, "更新库存管理员状态失败");
                }

            } else {
                int stock = banGongService.queryStock(supplyName, supplyType);
                int num = banGongService.querySupplyByName(supplyName, supplyType);
                if (num == 0) {
                    return new ResponseMessage(Code.CODE_ERROR, "该物品库存不存在，请发起采购或拒绝");
                } else {
                    if (applyCount > stock) {
                        return new ResponseMessage(Code.CODE_ERROR, "库存数量不足,请发起采购或拒绝");
                    }
                    int newStock = stock - applyCount;
                    int f2 = banGongService.updateSupplies1(newStock, supplyName, supplyType);
                    if (f2 != 1) {
                        return new ResponseMessage(Code.CODE_ERROR, "更新库存失败");
                    }
                    TXietongSuppliesApplyRecord applyRecords = new TXietongSuppliesApplyRecord();
                    applyRecords.setApplyId(id);
                    applyRecords.setOwnerId(repositoryId);
                    //设置同意不同意
                    applyRecords.setOpinion(opinion);
                    applyRecords.setStatus(1);
                    //如果仓管员临时修改了申请数量  将修改后数量放入
                    // 临时用这个无用字段
                    applyRecords.setIscc(applyCount);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
                    Date time = null;
                    try {
                        time = sdf.parse(sdf.format(new Date()));
                    } catch (Exception e) {
                        logger.debug("转换时间格式出错", e);
                        e.printStackTrace();
                        return new ResponseMessage(Code.CODE_ERROR, "时间转换错误");
                    }
                    applyRecords.setDealTime(time);
                    applyRecords.setIsRead(1);
                    int flag = banGongService.updateapplyRecord1(applyRecords);
                    if (flag != 1) {
                        return new ResponseMessage(Code.CODE_ERROR, "更新库存管理员状态失败");
                    }
                    //applytype为1 :用品发放
                    String recordId = banGongService.queryRecordId(applyRecords.getApplyId(), applyRecords.getOwnerId());
                    daibanUtil.UpdateDaibanRecord(recordId);

                    TXietongSupplyRecord supplyRecord = new TXietongSupplyRecord();
                    supplyRecord.setId(UUID.randomUUID().toString());
                    supplyRecord.setSupplyId(supplyId);
                    supplyRecord.setSupplyName(supplyName);
                    supplyRecord.setSupplyType(supplyType);
       /* Map<String, String> map = userInfoUtil.getUserInfo(ownerId);*/
                    //这里是添加的申请人的信息
                    supplyRecord.setReceiptorId(applyId);
                    supplyRecord.setReceiptorDepartId(applyDepId);
                    supplyRecord.setReamark(recComment);
                    supplyRecord.setIsdelete(0);
                    Double price = banGongService.queryPrice(supplyName, supplyType);
                    supplyRecord.setPrice(price);
                    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
                    Date time1 = null;
                    try {
                        time1 = sdf.parse(sdf.format(new Date()));
                    } catch (Exception e) {
                        logger.debug("转换时间格式出错", e);
                        e.printStackTrace();
                        return new ResponseMessage(Code.CODE_ERROR, "时间转换错误");
                    }
                    supplyRecord.setCreatetime(time1);
                    supplyRecord.setAmount(applyCount);
                    supplyRecord.setReceiptorName(applyName);
                    supplyRecord.setReceiptorDepartName(applyDepName);
                    int f3 = banGongService.addSupplyRecord(supplyRecord);
                    if (f3 != 1) {
                        return new ResponseMessage(Code.CODE_ERROR, "添加到记录表失败");
                    }
                    int ffl = banGongService.updateRepositoryStatus(id, rstatus);
                    if (ffl != 1) {
                        return new ResponseMessage(Code.CODE_ERROR, "更新库存管理员状态失败");
                    }
                }
            }
            return new ResponseMessage(Code.CODE_OK, "更新库存成功并添加到记录表");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(tag + "handleResult() error..." + e);
            return new ResponseMessage(Code.CODE_ERROR, "服务器异常", e);
        }
    }

    /*------------------------采购-------------------------*/
//仓管发起采购请求
    @LogInfo(methodName = "addSupply")
    @RequestMapping(value = "/addSupply")
    @ResponseBody
    public ResponseMessage addSupply(@RequestBody String requestBody) {
        logger.debug(tag + "addSupply() begin...requestBody", requestBody);
        try {
            JSONObject requestJson = JSONObject.parseObject(requestBody);
            String nameId = requestJson.getString("nameId");
            String name = requestJson.getString("name");
            String type = requestJson.getString("type");
            String typeId = requestJson.getString("typeId");
            Integer amount = requestJson.getInteger("amount");
            //申请发起者的Id-->仓管
            String applyId = requestJson.getString("ownerId");
            String applyName = requestJson.getString("ownerName");
            String reason = requestJson.getString("reason");
            String applyDepName = requestJson.getString("applyDepName");
            //指定的审核人的Id
            String ownerId = requestJson.getString("applyId");
            String ownerName = requestJson.getString("applyName");
            String category = requestJson.getString("category");
            String categoryId = requestJson.getString("categoryId");
            String user = requestJson.getString("user");
            String userId = requestJson.getString("userId");
            String attribute=requestJson.getString("attribute");
            TXietongSuppliesApply suppliesApply = new TXietongSuppliesApply();
            suppliesApply.setId(UUID.randomUUID().toString());
            suppliesApply.setStatus("1");
            suppliesApply.setIsdelete(0);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            Date time = null;
            try {
                time = sdf.parse(sdf.format(new Date()));
            } catch (Exception e) {
                logger.debug("转换时间格式出错", e);
                e.printStackTrace();
                return new ResponseMessage(Code.CODE_ERROR, "时间转换错误");
            }
            suppliesApply.setCreatetime(time);
            suppliesApply.setNextApproverId(ownerId);
            suppliesApply.setNextApprover(ownerName);
            suppliesApply.setSupplyType(type);
            suppliesApply.setSupplyId(nameId);
            suppliesApply.setApplyId(applyId);
            suppliesApply.setApplyName(applyName);
            suppliesApply.setApplyDepName(applyDepName);
            suppliesApply.setApplyCount(amount);
            suppliesApply.setContent(reason);
            suppliesApply.setSupplyName(name);
            suppliesApply.setRequestType("2");
            suppliesApply.setRstatus("1");
            //未采购  还没有记录   给默认值为0
            suppliesApply.setPstatus("-1");
            suppliesApply.setBstatus("0");
            suppliesApply.setCategory(category);
            suppliesApply.setCategoryId(categoryId);
            suppliesApply.setUser(user);
            suppliesApply.setUserId(userId);
            //仓库管理员发起的code为-1
            suppliesApply.setCode(-1);
            suppliesApply.setIsApplying(0);
            //这个申请表的字段用来存放物品属性  字段不够用了
            suppliesApply.setNextRecordIds(attribute);
            int flag = banGongService.addSuppliedApply(suppliesApply);
            if (flag != 1) {
                return new ResponseMessage(Code.CODE_ERROR, "添加进申请明细失败");
            }
            TXietongSuppliesApplyRecord applyRecord = new TXietongSuppliesApplyRecord();
            applyRecord.setId(UUID.randomUUID().toString());
            applyRecord.setApplyId(suppliesApply.getId());
            applyRecord.setOwnerId(ownerId);
            applyRecord.setOwnerName(ownerName);
            applyRecord.setCreatetime(time);
            applyRecord.setIsdelete(0);
            applyRecord.setStatus(0);
            applyRecord.setApplyType(0);
            int f = banGongService.addApplyRecords(applyRecord);
            if (f != 1) {
                return new ResponseMessage(Code.CODE_ERROR, "指定办公室处理人失败");
            }
            //生成通知
            daibanUtil.insertDaibanRecord(applyRecord.getId(), reason, "bgyp0", applyRecord.getOwnerId());
        /*//仓库管理员记录表
            TXietongSuppliesApplyRecord applyRecord2 = new TXietongSuppliesApplyRecord();
            applyRecord2.setId(UUID.randomUUID().toString());
            applyRecord2.setApplyId(suppliesApply.getId());
            applyRecord2.setOwnerId(applyId);
            applyRecord2.setOwnerName(applyName);
            applyRecord2.setCreatetime(time);
            applyRecord2.setIsdelete(0);
            //仓管员为0；
            applyRecord2.setStatus(0);
            int f2 = banGongService.addApplyRecords(applyRecord2);
            if (f2 != 1) {
                return new ResponseMessage(Code.CODE_ERROR, "生成仓库管员记录失败");
            }*/

            return new ResponseMessage(Code.CODE_OK, "发送采购申请成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(tag + "addSupply() begin...requestBody", e);
            return new ResponseMessage(Code.CODE_ERROR, "服务器异常", e);
        }
    }


    //办公室发起采购请求
    @LogInfo(methodName = "OfficerSupply")
    @RequestMapping(value = "/OfficerSupply")
    @ResponseBody
    public ResponseMessage OfficerSupply(@RequestBody String requestBody) {
        logger.debug(tag + "OfficerSupply() begin...requestBody", requestBody);
        try {
            JSONObject requestJson = JSONObject.parseObject(requestBody);
            //类别
            String category = requestJson.getString("category");
            String categoryId = requestJson.getString("categoryId");
            //用品名称
            String nameId = requestJson.getString("nameId");
            String name = requestJson.getString("name");
            //类别
            String type = requestJson.getString("type");
            String typeId = requestJson.getString("typeId");
            //申请数量
            Integer amount = requestJson.getInteger("amount");
            //申请发起人的Id
            String applyId = requestJson.getString("applyId");
            String applyName = requestJson.getString("applyName");
            //指定的审核人的Id
            String ownerId = requestJson.getString("ownerId");
            String ownerName = requestJson.getString("ownerName");
            //申请原因
            String reason = requestJson.getString("reason");
            //申请部门
            String applyDepName = requestJson.getString("applyDepName");

            //使用人
            String user = requestJson.getString("user");
            String userId = requestJson.getString("userId");
            TXietongSuppliesApply suppliesApply = new TXietongSuppliesApply();
            suppliesApply.setId(UUID.randomUUID().toString());
            suppliesApply.setStatus("1");
            suppliesApply.setIsdelete(0);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            Date time = null;
            try {
                time = sdf.parse(sdf.format(new Date()));
            } catch (Exception e) {
                logger.debug("转换时间格式出错", e);
                e.printStackTrace();
                return new ResponseMessage(Code.CODE_ERROR, "时间转换错误");
            }

            suppliesApply.setCreatetime(time);
            //下一个审核人
            suppliesApply.setNextApproverId(ownerId);
            suppliesApply.setNextApprover(ownerName);
            suppliesApply.setSupplyType(type);
            suppliesApply.setSupplyId(nameId);
            suppliesApply.setSupplyName(name);
            suppliesApply.setApplyId(applyId);
            suppliesApply.setApplyName(applyName);
            suppliesApply.setApplyDepName(applyDepName);
            suppliesApply.setApplyCount(amount);
            suppliesApply.setContent(reason);
            //采购申请  办公室查询是没有条件的 1和2都可以查出来
            suppliesApply.setRequestType("2");
            //自己发起的申请  暂时不给状态
          /* suppliesApply.setBstatus("0");*/
            //pstatus :-1未处理
            suppliesApply.setPstatus("-1");
            //rstatus  :0:未处理
            suppliesApply.setRstatus("0");
            suppliesApply.setCategory(category);
            suppliesApply.setCategoryId(categoryId);
            suppliesApply.setUser(user);
            suppliesApply.setUserId(userId);
            //code为2   代表这条申请是办公室
            suppliesApply.setCode(2);
            suppliesApply.setIsApplying(1);
            int flag = banGongService.addSuppliedApply(suppliesApply);
            if (flag != 1) {
                return new ResponseMessage(Code.CODE_ERROR, "添加进申请表失败");
            }

            //后退一秒
            Long time3 = System.currentTimeMillis();
            time3 += 1000;
            Date date = new Date(time3);
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            Date d = sdf.parse(sdf2.format(date));
            TXietongSuppliesApplyRecord applyRecord = new TXietongSuppliesApplyRecord();
            applyRecord.setId(UUID.randomUUID().toString());
            applyRecord.setApplyId(suppliesApply.getId());
            applyRecord.setOwnerId(ownerId);
            applyRecord.setOwnerName(ownerName);
            applyRecord.setCreatetime(d);
            applyRecord.setIsdelete(0);
            applyRecord.setStatus(0);
            //applytype为0  代表用品审批
            applyRecord.setApplyType(0);
            int f = banGongService.addApplyRecords(applyRecord);
            if (f != 1) {
                return new ResponseMessage(Code.CODE_ERROR, "指定审核人失败");
            }
            //生成通知
            daibanUtil.insertDaibanRecord(applyRecord.getId(), reason, "bgyp0", applyRecord.getOwnerId());
            //给申请人申城一条记录
            TXietongSuppliesApplyRecord applyRecord2 = new TXietongSuppliesApplyRecord();
            applyRecord2.setId(UUID.randomUUID().toString());
            applyRecord2.setApplyId(suppliesApply.getId());
            applyRecord2.setOwnerId(applyId);
            applyRecord2.setOwnerName(applyName);
            applyRecord2.setCreatetime(time);
            applyRecord2.setIsdelete(0);
            //发起时已经审批
            applyRecord2.setStatus(1);
            //applytype为0  代表用品审批
            applyRecord2.setApplyType(0);
            applyRecord2.setOpinion(0);
            //是否已经处理  0:还未处理
            applyRecord2.setIsParallel(0);
            int f2 = banGongService.addApplyRecords(applyRecord2);
            if (f2 != 1) {
                return new ResponseMessage(Code.CODE_ERROR, "指定审核人失败");
            }
            //生成通知
            daibanUtil.insertDaibanRecord(applyRecord2.getId(), reason, "bgyp0", applyRecord2.getOwnerId());

            return new ResponseMessage(Code.CODE_OK, "发送采购申请成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(tag + "addSupply() begin...requestBody", e);
            return new ResponseMessage(Code.CODE_ERROR, "服务器异常", e);
        }
    }

    //   办公室选择新的审核人
    @LogInfo(methodName = "addNewOfficer")
    @RequestMapping(value = "/addNewOfficer")
    @ResponseBody
    public ResponseMessage addNewOfficer(@RequestBody String requestBody) {
        logger.debug(tag + "CaiGouOffier() begin...requestBody", requestBody);
        JSONObject requestJson = JSONObject.parseObject(requestBody);
        String id = requestJson.getString("id");
        String ownerId = requestJson.getString("ownerId");
        String ownerName = requestJson.getString("ownerName");
        String content = requestJson.getString("content");
        String opinion = requestJson.getString("opinion");
        TXietongSuppliesApplyRecord applyRecord = new TXietongSuppliesApplyRecord();
        applyRecord.setId(UUID.randomUUID().toString());
        applyRecord.setApplyId(id);
        applyRecord.setOwnerId(ownerId);
        applyRecord.setOwnerName(ownerName);
        applyRecord.setRecComment(content);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        Date time = null;
        try {
            time = sdf.parse(sdf.format(new Date()));
        } catch (Exception e) {
            logger.debug("转换时间格式出错", e);
            e.printStackTrace();
            return new ResponseMessage(Code.CODE_ERROR, "时间转换错误");
        }
        applyRecord.setCreatetime(time);
        applyRecord.setIsdelete(0);
        applyRecord.setStatus(0);
        //applytype为0  代表用品审批
        applyRecord.setApplyType(0);
        int f = banGongService.addApplyRecords(applyRecord);
        if (f != 1) {
            return new ResponseMessage(Code.CODE_ERROR, "指定审核人失败");
        }
        daibanUtil.insertDaibanRecord(applyRecord.getId(), content, "bgyp0", applyRecord.getOwnerId());
        return new ResponseMessage(Code.CODE_OK, "指定审核人成功");
        //生成通知
    }

    //采购按钮  办公室发给采购员和仓库管理员
    @LogInfo(methodName = "CaiGouOffier")
    @RequestMapping(value = "/CaiGouOffier")
    @ResponseBody
    public ResponseMessage CaiGouOffier(@RequestBody String requestBody) {
        logger.debug(tag + "CaiGouOffier() begin...requestBody", requestBody);
        JSONObject requestJson = JSONObject.parseObject(requestBody);
        String id = requestJson.getString("id");
        String supplyName = requestJson.getString("supplyName");
        String supplyId = requestJson.getString("supplyId");
        String supplyType = requestJson.getString("supplyType");
        Integer applyCount = requestJson.getInteger("applyCount");
        String content = requestJson.getString("content");
        String applyName = requestJson.getString("applyName");
        String applyId = requestJson.getString("applyId");
        String applyDepName = requestJson.getString("applyDepName");
        String category = requestJson.getString("category");
        String categoryId = requestJson.getString("categoryId");
        String user = requestJson.getString("user");
        String userId = requestJson.getString("userId");
        Long repositoryId = banGongService.queryRepositoryId();
        String repositoryId1 = repositoryId.toString();
        Long caiGouYuanId = banGongService.queryCaiGouYuanId();
        String caiGouYuanId1 = caiGouYuanId.toString();
        JSONArray jsonArray = requestJson.getJSONArray("Redirector");
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jo = jsonArray.getJSONObject(i);
            //这里的ownerid是指定的多个审核人的id
            String redirectorId = jo.getString("redirectorManId");
            String redirectorName = jo.getString("redirectorManName");
            if (caiGouYuanId1.equals(redirectorId)) {
                TXietongSuppliesApplyRecord applyRecord = new TXietongSuppliesApplyRecord();
                applyRecord.setId(UUID.randomUUID().toString());
                applyRecord.setApplyId(id);
                applyRecord.setOwnerId(redirectorId);
                applyRecord.setOwnerName(redirectorName);
                applyRecord.setRecComment(content);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date time = null;
                try {
                    time = sdf.parse(sdf.format(new Date()));
                } catch (Exception e) {
                    logger.debug("转换时间格式出错", e);
                    e.printStackTrace();
                    return new ResponseMessage(Code.CODE_ERROR, "时间转换错误");
                }
                applyRecord.setCreatetime(time);
                applyRecord.setIsdelete(0);
                applyRecord.setStatus(0);
                applyRecord.setIsRead(0);
                //创建者的id也就是申请人的id
                applyRecord.setCreatorId(applyId);
                applyRecord.setCreatorName(applyName);
                applyRecord.setOpinion(0);
                applyRecord.setOwnerName(applyName);
                applyRecord.setDepartName(applyDepName);
                applyRecord.setApplyType(2);
                int f = banGongService.addApplyRecords(applyRecord);
                if (f != 1) {
                    return new ResponseMessage(Code.CODE_ERROR, "发送采购信息失败");
                }
                //生成通知
                daibanUtil.insertDaibanRecord(applyRecord.getId(), content, "bgyp2", applyRecord.getOwnerId());

            }/* else if (repositoryId1.equals(redirectorId)) {
                 *//*   TXietongSuppliesApply suppliesApply = new TXietongSuppliesApply();
                    suppliesApply.setId(UUID.randomUUID().toString());
                    suppliesApply.setStatus("1");
                    suppliesApply.setIsdelete(0);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
                    Date time = null;
                    try {
                        time = sdf.parse(sdf.format(new Date()));
                    } catch (Exception e) {
                        logger.debug("转换时间格式出错", e);
                        e.printStackTrace();
                        return new ResponseMessage(Code.CODE_ERROR, "时间转换错误");
                    }
                    suppliesApply.setCreatetime(time);
                    suppliesApply.setNextApproverId(applyId);
                    suppliesApply.setNextApprover(applyName);
                    suppliesApply.setSupplyType(supplyType);
                    suppliesApply.setSupplyId(supplyId);
                    suppliesApply.setApplyId(applyId);
                    suppliesApply.setApplyName(applyName);
                    suppliesApply.setApplyDepName(applyDepName);
                    suppliesApply.setApplyCount(applyCount);
                    suppliesApply.setContent(content);
                    suppliesApply.setSupplyName(supplyName);
                    suppliesApply.setRequestType("2");
                    suppliesApply.setRstatus("1");
                    //未采购  还没有记录   给默认值为0
                    suppliesApply.setPstatus("-1");
                    suppliesApply.setBstatus("0");
                    suppliesApply.setCategory(category);
                    suppliesApply.setCategoryId(categoryId);
                    suppliesApply.setUser(user);
                    suppliesApply.setUserId(userId);
                    //仓库管理员发起的code为-1
                    suppliesApply.setCode(-1);
                    int flag = banGongService.addSuppliedApply(suppliesApply);
                    if (flag != 1) {
                        return new ResponseMessage(Code.CODE_ERROR, "添加进申请明细失败");
                    }*//*
                TXietongSuppliesApplyRecord applyRecord = new TXietongSuppliesApplyRecord();
                applyRecord.setId(UUID.randomUUID().toString());
                applyRecord.setApplyId(id);
                applyRecord.setOwnerId(redirectorId);
                applyRecord.setRecComment(content);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date time = null;
                try {
                    time = sdf.parse(sdf.format(new Date()));
                } catch (Exception e) {
                    logger.debug("转换时间格式出错", e);
                    e.printStackTrace();
                    return new ResponseMessage(Code.CODE_ERROR, "时间转换错误");
                }
                applyRecord.setCreatetime(time);
                applyRecord.setIsdelete(0);
                applyRecord.setStatus(0);
                applyRecord.setIsRead(0);
                //创建者的id也就是申请人的id
                applyRecord.setCreatorId(applyId);
                applyRecord.setCreatorName(applyName);
                applyRecord.setOpinion(0);
                applyRecord.setOwnerName(redirectorId);
                applyRecord.setDepartName(applyDepName);
                applyRecord.setApplyType(2);
                int f = banGongService.addApplyRecords(applyRecord);
                if (f != 1) {
                    return new ResponseMessage(Code.CODE_ERROR, "指定仓库管理员失败");
                }
                //生成通知
                daibanUtil.insertDaibanRecord(applyRecord.getId(), content, "bgyp1", applyRecord.getOwnerId());
            }*/
        }
        TXietongSuppliesApply suppliesApply = new TXietongSuppliesApply();
        suppliesApply.setId(id);
        suppliesApply.setCode(3);
        suppliesApply.setIsApplying(0);
        /*suppliesApply.setBstatus("1");*/
        int ff = banGongService.updateApplyStatus(id, applyId);
        //
        String recordId = banGongService.queryRecordIdBanGong(id, applyId);
        daibanUtil.UpdateDaibanRecord(recordId);
        if (ff != 1) {
            return new ResponseMessage(Code.CODE_OK, "更新申请人状态状态失败");
        }
        int f = banGongService.updateSypplyApply(suppliesApply);
        if (f == 1) {
            return new ResponseMessage(Code.CODE_OK, "更新主表状态成功");
        } else {
            return new ResponseMessage(Code.CODE_ERROR, "更新主表状态失败");
        }
    }


    // ---------------------采购审批结果列表接口-----------------------
    //调用handleApply接口
    //采购员查询采购申请
    @LogInfo(methodName = "采购员列表查询")
    @RequestMapping(value = "/queryCaiGouList")
    @ResponseBody
    public ResponseMessage queryCaiGouList(@RequestBody String requestBody) {
        logger.debug(tag + "queryCaiGouList() begin...requestBody", requestBody);
        try {
            JSONObject requestJson = JSONObject.parseObject(requestBody);
            String supplyName = requestJson.getString("supplyName");
            String supplyId = requestJson.getString("supplyId");
            String applyName = requestJson.getString("applyName");
            String ownerId = requestJson.getString("ownerId");
            String applyId = requestJson.getString("applyId");
            String pageNum = requestJson.getString("pageNum");
            String pageCount = requestJson.getString("pageCount");
            Page<TXietongSuppliesApply> page = new Page<>();
            int totalNumber = banGongService.getCaiGouCount(supplyName, applyName, ownerId);
            page.init(totalNumber, Integer.valueOf(pageNum), Integer.valueOf(pageCount));
            List<TXietongSuppliesApply> list = banGongService.queryCaiGouList(supplyName, applyName, ownerId, page.getRowNum(), page.getPageCount());
            for (TXietongSuppliesApply suppliesApply : list) {
                String supplyId1 = suppliesApply.getSupplyId();
                String supplyType1 = suppliesApply.getSupplyType();
                int stock = banGongService.queryStock(supplyId1, supplyType1);
                suppliesApply.setStock(stock);
            }
            page.setList(list);
            page.setTypeApply(2);
            return new ResponseMessage(Code.CODE_OK, "分页信息", page);
        } catch (Exception e) {
            logger.debug(tag + "queryCaiGouList() error...=", e);
            return responseMessage = new ResponseMessage(Code.CODE_ERROR, "服务器异常" + e);
        }
    }

    @LogInfo(methodName = "采购员列表查询")
    @RequestMapping(value = "/queryCaiGouList1")
    @ResponseBody
    public ResponseMessage queryCaiGouList1(@RequestBody String requestBody) {
        logger.debug(tag + "queryCaiGouList() begin...requestBody", requestBody);
        try {
            JSONObject requestJson = JSONObject.parseObject(requestBody);
            String supplyName = requestJson.getString("supplyName");
            String supplyId = requestJson.getString("supplyId");
            String applyName = requestJson.getString("applyName");
            String ownerId = requestJson.getString("ownerId");
            String applyId = requestJson.getString("applyId");
            String pageNum = requestJson.getString("pageNum");
            String pageCount = requestJson.getString("pageCount");
            Page<TXietongSuppliesApply> page = new Page<>();
            int totalNumber = banGongService.getCaiGouCountDaiBan(supplyName, applyName, ownerId);
            page.init(totalNumber, Integer.valueOf(pageNum), Integer.valueOf(pageCount));
            List<TXietongSuppliesApply> list = banGongService.queryCaiGouListDaiBan(supplyName, applyName, ownerId, page.getRowNum(), page.getPageCount());
            for (TXietongSuppliesApply suppliesApply : list) {
                String supplyId1 = suppliesApply.getSupplyId();
                String supplyType1 = suppliesApply.getSupplyType();
                int stock = banGongService.queryStock(supplyId1, supplyType1);
                suppliesApply.setStock(stock);
            }
            page.setList(list);
            page.setTypeApply(2);
            return new ResponseMessage(Code.CODE_OK, "分页信息", page);
        } catch (Exception e) {
            logger.debug(tag + "queryCaiGouList() error...=", e);
            return responseMessage = new ResponseMessage(Code.CODE_ERROR, "服务器异常" + e);
        }
    }

    //---------------------详情-------------------------------
    //queryhandleDetails

    //----------------------------------采购详情页面-------------------------------------
/*    @LogInfo(methodName = "查询采购申请")
    @RequestMapping(value = "/queryPucharseDetails")
    @ResponseBody
    public ResponseMessage queryPucharseDetails(@RequestBody String requestBody) {
        logger.debug("querySupplyApplying() begin...requestBody", requestBody);
        JSONObject requestJson = JSONObject.parseObject(requestBody);
        String  supplyId=requestJson.getString("supplyId");
        String supplyName=requestJson.getString("supplyName");
        String supplyType=requestJson.getString("supplyType");
        //这是当前登录人的Id
        String ownerId=requestJson.getString("ownerId");

    }*/


    //------------------------------------------
    //
    // -------------------------------
    @LogInfo(methodName = "insertToRepostotory")
    @RequestMapping(value = "/insertToRepostotory")
    @ResponseBody
    public ResponseMessage insertToRepostotory(@RequestBody String requestBody) {
        logger.debug(tag + "insertToRepostotory() begin...requestBody", requestBody);
        try {
            JSONObject requestJson = JSONObject.parseObject(requestBody);
            String supplyId = requestJson.getString("supplyId");
            String supplyName = requestJson.getString("supplyName");
            String supplyType = requestJson.getString("supplyType");

            Integer amount = requestJson.getInteger("amount");
            String id = requestJson.getString("id");
            String cangguanyuanId = requestJson.getString("cangguanyuanId");
            //如果勾选了入库复选框  发送状态为2
            Integer status = requestJson.getInteger("status");
            String category = requestJson.getString("category");
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH) + 1;
            int day = cal.get(Calendar.DATE);//获取日
            int hour = cal.get(Calendar.HOUR_OF_DAY);
            int minute = cal.get(Calendar.MINUTE);
            int second = cal.get(Calendar.SECOND);
            String time2 = year + "" + month + day + hour + minute + second;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date time = null;
            try {
                time = sdf.parse(sdf.format(new Date()));
            } catch (Exception e) {
                logger.debug("转换时间格式出错", e);
                e.printStackTrace();
                return new ResponseMessage(Code.CODE_ERROR, "时间转换错误");
            }
            List<String> attributes=banGongService.queryAttributeFromApply(supplyName,supplyType);
            Integer attribute;
            if(attributes.size()!=0){
                attribute=Integer.parseInt(attributes.get(0));
            }else {
                attribute=0;
            }
            if (status == 2) {
                int ff = banGongService.querySupply(supplyName, supplyType);
                //如果查到了  说明库里已经有了  进行添加
                if (ff == 1) {
                    int stock = banGongService.queryStock(supplyName, supplyType);
                    int newStcok = stock + amount;
                    int f2 = banGongService.updateSupplies(newStcok, supplyName, supplyType,attribute);
                    if (f2 != 1) {
                        return new ResponseMessage(Code.CODE_ERROR, "更新主表库存失败，请确保所有参数正缺");
                    }
                } else {
                    TXietongSupplies supplies = new TXietongSupplies();
                    supplies.setId(UUID.randomUUID().toString());
                    supplies.setName(supplyName);
                    supplies.setType(supplyType);
                    supplies.setStock(amount);
                    supplies.setCreatetime(time);
                    supplies.setIsdelete(0);
                    supplies.setNameId(supplyId);
                    supplies.setEncode(time2);
                    supplies.setAttribute(attribute);
                    supplies.setCategory(category);
                    int flag = banGongService.addBanGong(supplies);
                    if (flag != 1) {
                        return new ResponseMessage(Code.CODE_OK, "办公用品添加失败");
                    }
                    // -----------------------------------在编辑的时候进行下拉框的更改---------------------------------------------
                    TXietongSuppliesCategory category1 = banGongService.queryCategoryClass(category);
                    TXietongSuppliesRepository repository = banGongService.queryRepository(supplyName);
                    //查询出来为空说明种类库里没有
                    if (category1 == null) {
                        //将新的种类添加进进去
                        String categoryid2 = UUID.randomUUID().toString();
                        int f = banGongService.insertCategory(categoryid2, category);
                        if (f != 1) {
                            return new ResponseMessage(Code.CODE_ERROR, "添加类别失败");
                        }
                        //如果repository为空  说明这个用品名称不存在
                        if (repository == null) {
                            int f1 = banGongService.insertSupply(supplyName, categoryid2);
                            if (f1 != 1) {
                                return new ResponseMessage(Code.CODE_ERROR, "添加名称失败");
                            }
                            int typeId = banGongService.queryNameId(supplyName, categoryid2);
                            int f2 = banGongService.insertType(supplyType, typeId);
                            if (f2 != 1) {
                                return new ResponseMessage(Code.CODE_ERROR, "添加类别失败");
                            }
                        }
                        //  该种类没有   但是该名称已经存在   更新该用品到新的类别 判断有没有该类别；
                        else {
                            int f3 = banGongService.updateRepository(supplyName, categoryid2);
                            if (f3 != 1) {
                                return new ResponseMessage(Code.CODE_ERROR, "更新种类失败");
                            }
                            int typeId = banGongService.queryNameId(supplyName, categoryid2);
                            int num = banGongService.queryRepositoryType(supplyType, typeId);
                            //如果没有该类别   添加
                            if (num == 0) {
                                int f4 = banGongService.insertType(supplyType, typeId);
                                if (f4 != 1) {
                                    return new ResponseMessage(Code.CODE_ERROR, "添加类别失败");
                                }
                            }
                            //有该类别 不做任何操作
                     /* else{
                          banGongService.updateRepositoryType(type,typeId);
                      }*/
                        }
                    }
                    //种类不为空
                    else {
                        String category1Id = category1.getId();
                        //类别已经存在  用品名称为空
                        if (repository == null) {
                            //先插入名称  和对应的种类id；
                            int f5 = banGongService.insertSupply(supplyName, category1Id);
                            if (f5 != 1) {
                                return new ResponseMessage(Code.CODE_ERROR, "添加类别失败");
                            }
                            //再插入对应的类别；
                            int typeId = banGongService.queryNameId(supplyName, category1Id);
                            int f6 = banGongService.insertType(supplyType, typeId);
                            if (f6 != 1) {
                                return new ResponseMessage(Code.CODE_ERROR, "添加用品类别失败");
                            }
                        }
                        //如果repository不为空   说明这个种类已经有了  用品名称也有  但是没有该类别
                        else {
                            int typeid = repository.getId();
                            int num = banGongService.queryRepositoryType(supplyType, typeid);
                            //类别有  用品名称有  类别没有  添加类别
                            if (num == 0) {
                                banGongService.insertType(supplyType, typeid);
                            }/*else{
                           banGongService.updateRepositoryType(type,typeid);
                       }*/
                        }
                    }
                    //  -----------------------------------在编辑的时候进行下拉框的更改---------------------------------------------
                }
                TXietongSuppliesApply suppliesApply = new TXietongSuppliesApply();
                suppliesApply.setId(id);
                suppliesApply.setRstatus(status.toString());
                suppliesApply.setEndtime(time);
                int flag = banGongService.updateSupplyStatus(suppliesApply);
                if (flag != 1) {
                    return new ResponseMessage(Code.CODE_ERROR, "更新主表状态失败");
                }
                return new ResponseMessage(Code.CODE_OK, "更新主表状态成功");
            }
            return new ResponseMessage(Code.CODE_OK, "未选定入库，没有更新主表状态");
        } catch (Exception e) {
            logger.debug(tag + "insertToRepostotory() error...=", e);
            return responseMessage = new ResponseMessage(Code.CODE_ERROR, "服务器异常" + e);
        }
    }

          /*  TXietongSuppliesApplyRecord applyRecords = new TXietongSuppliesApplyRecord();
            applyRecords.setApplyId(id);
            applyRecords.setOwnerId(cangguanyuanId);
            applyRecords.setStatus(status);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            Date time = null;
            try {
                time = sdf.parse(sdf.format(new Date()));
            } catch (Exception e) {
                logger.debug("转换时间格式出错", e);
                e.printStackTrace();
                return new ResponseMessage(Code.CODE_ERROR, "时间转换错误");
            }
            applyRecords.setDealTime(time);
            applyRecords.setIsRead(1);
            int flag = banGongService.updateapplyRecord(applyRecords);
            if (flag != 1) {
                return new ResponseMessage(Code.CODE_ERROR, "更新库存管理状态失败");
            }
            return new ResponseMessage(Code.CODE_OK, "更新管理员状态成功");
        }*/

    //采购员进行状态更改
    @LogInfo(methodName = "addtoRepository")
    @RequestMapping(value = "/addtoRepository")
    @ResponseBody
    public ResponseMessage addtoRepository(@RequestBody String requestBody) {
        logger.debug(tag + "addtoRepository() begin...requestBody", requestBody);
        try {
            JSONObject requestJson = JSONObject.parseObject(requestBody);
            String supplyId = requestJson.getString("supplyId");
            String supplyName = requestJson.getString("supplyName");
            String supplyType = requestJson.getString("supplyType");
            Integer amount = requestJson.getInteger("amount");

            String id = requestJson.getString("id");
            String caigouyuanId = requestJson.getString("caigouyuanId");
            //采购状态：-1：未处理，0：未采购，1，已采购
            //如果为1为已采购
            Integer status = requestJson.getInteger("status");
            if (status == 1) {
                TXietongSuppliesApply suppliesApply = new TXietongSuppliesApply();
                suppliesApply.setId(id);
                suppliesApply.setPstatus(status.toString());

              /*  TXietongSuppliesApplyRecord applyRecords = new TXietongSuppliesApplyRecord();
                applyRecords.setApplyId(id);
                applyRecords.setOwnerId(caigouyuanId);
                applyRecords.setStatus(status);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
                Date time = null;
                try {
                    time = sdf.parse(sdf.format(new Date()));
                } catch (Exception e) {
                    logger.debug("转换时间格式出错", e);
                    e.printStackTrace();
                    return new ResponseMessage(Code.CODE_ERROR, "时间转换错误");
                }
                applyRecords.setDealTime(time);
                applyRecords.setIsRead(1);*/
                int flag = banGongService.updatePstatus(suppliesApply);
                //这个id查询应该不对
                //==================================
                String recordId = banGongService.queryRecordCaiGouId(id, caigouyuanId);
                daibanUtil.UpdateDaibanRecord(recordId);
                if (flag != 1) {
                    return new ResponseMessage(Code.CODE_ERROR, "更新库采购员状态失败");
                }
                return new ResponseMessage(Code.CODE_OK, "更新库采购员状态成功");
            } else {
                //如果是未采购
                TXietongSuppliesApply suppliesApply = new TXietongSuppliesApply();
                suppliesApply.setId(id);
                suppliesApply.setPstatus(status.toString());
                int flag = banGongService.updatePstatus(suppliesApply);
                String recordId = banGongService.queryRecordCaiGouId(id, caigouyuanId);
                daibanUtil.UpdateDaibanRecord(recordId);
                if (flag != 1) {
                    return new ResponseMessage(Code.CODE_ERROR, "更新库采购员状态失败");
                }
                return new ResponseMessage(Code.CODE_OK, "更新库采购员状态成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(tag + "addtoRepository() error ...", e);
            return new ResponseMessage(Code.CODE_ERROR, "服务器异常", e);
        }
    }


    @LogInfo(methodName = "deleteRepository")
    @RequestMapping(value = "/deleteRepository")
    @ResponseBody
    public ResponseMessage deleteRepository(@RequestBody String requestBody) {
        logger.debug(tag + "deleteRepository() begin...requestBody", requestBody);
        try {
            JSONObject requestJson = JSONObject.parseObject(requestBody);
            String id = requestJson.getString("id");

            TXietongSupplies supplies = banGongService.querySupplysById(id);
            if (supplies == null) {
                return new ResponseMessage(Code.CODE_ERROR, "请确保id正确，类型唯一");
            }
            int flag = banGongService.deleteRepository(id);
            int f = banGongService.deleteSupplyRecord(supplies.getName(), supplies.getType());

            if (flag == 1) {
                return new ResponseMessage(Code.CODE_OK, "删除库存成功");
            }
            return new ResponseMessage(Code.CODE_ERROR, "删除库存成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(tag + "deleteRepository() error...", e);
            return new ResponseMessage(Code.CODE_ERROR, "服务器异常", e);
        }
    }

    //指定办公室审核人
    @LogInfo(methodName = "updateOfficer")
    @RequestMapping(value = "/updateOfficer")
    @ResponseBody
    public ResponseMessage updateOfficer(@RequestBody String requestBody) {
        logger.error(tag + "updateOfficer()", requestBody);
        try {
            JSONObject requestJson = JSONObject.parseObject(requestBody);
            String id = requestJson.getString("id");
            String nameId = requestJson.getString("nameId");
            String name = requestJson.getString("name");
      /*  TXietongDictionary dic=new TXietongDictionary();*/
            int flag = banGongService.updateOfficer(id, nameId, name);
            if (flag != 1) {
                return new ResponseMessage(Code.CODE_ERROR, "指定办公室审核人失败");
            }
            return new ResponseMessage(Code.CODE_OK, "指定办公室审核人成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(tag + "updateOfficer()", e);
            return new ResponseMessage(Code.CODE_ERROR, "服务器异常", e);
        }
    }

    //查询原来的审核人
    @LogInfo(methodName = "queryOfficer")
    @RequestMapping(value = "/queryOfficer")
    @ResponseBody
    public ResponseMessage queryOfficer(@RequestBody String requestBody) {
        logger.debug(tag + "queryOfficer() begin ...requestBody", requestBody);
        try {
            JSONObject requestJson = JSONObject.parseObject(requestBody);
            String id = requestJson.getString("id");
            TXietongDictionary dic = banGongService.queryOfficer(id);
            if (dic == null) {
                return new ResponseMessage(Code.CODE_ERROR, "查询原来审核人失败");
            }
            return new ResponseMessage(Code.CODE_OK, "查询原来审核人成功", dic);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(tag + "queryOfficer() ereor...=", e);
            return new ResponseMessage(Code.CODE_ERROR, "服务器异常", e);
        }
    }

    //删除用品类别
    @LogInfo(methodName = "deleteCategory")
    @RequestMapping(value = "/deleteCategory")
    @ResponseBody
    public ResponseMessage deleteCategory(@RequestBody String requestBody) {

        JSONObject requestJson = JSONObject.parseObject(requestBody);
        String id = requestJson.getString("id");
        int f = banGongService.deleteCategory(id);
        if (f == 0) {
            return new ResponseMessage(Code.CODE_ERROR, "删除类别失败");
        }
        return new ResponseMessage(Code.CODE_OK, "删除类别成功");
    }

    //删除用品类型名称
    @LogInfo(methodName = "deleteName")
    @RequestMapping(value = "/deleteName")
    @ResponseBody
    public int deleteName(int id) {

       /* JSONObject requestJson = JSONObject.parseObject(requestBody);
        Integer id=requestJson.getInteger("id'");*/
        int f = banGongService.deleteName(id);
        return f;
    }

    //删除用品类型类型
    @LogInfo(methodName = "deleteType")
    @RequestMapping(value = "/deleteType")
    @ResponseBody
    public ResponseMessage deleteType(@RequestBody String requestBody) {
        logger.error(tag + "deleteName() begin...requestBody", requestBody);
        try {
            JSONObject requestJson = JSONObject.parseObject(requestBody);
            Integer id = requestJson.getInteger("id");
            int f = banGongService.deleteType(id);
            if (f == 0) {
                return new ResponseMessage(Code.CODE_ERROR, "删除类型失败");
            }
            return new ResponseMessage(Code.CODE_OK, "删除类型成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(tag + "deleteType()", e);
            return new ResponseMessage(Code.CODE_ERROR, "服务器异常", e);
        }
    }

    //删除用品名称和类型
    @LogInfo(methodName = "deleteNameandType")
    @RequestMapping(value = "/deleteNameandType")
    @ResponseBody
    public ResponseMessage deleteNameandType(@RequestBody String requestBody) {
        logger.error(tag + "deleteName() begin...requestBody", requestBody);
        try {
            JSONObject requestJson = JSONObject.parseObject(requestBody);
            Integer id = requestJson.getInteger("id");
            int f = this.deleteName(id);
            int f2 = banGongService.deleteType(id);
            if (f == 0) {
                return new ResponseMessage(Code.CODE_ERROR, "删除用品名称和类型失败");
            }
            return new ResponseMessage(Code.CODE_OK, "删除用品名称和类型成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(tag + "deleteNameandType()", e);
            return new ResponseMessage(Code.CODE_ERROR, "服务器异常", e);
        }
    }

    /*   //指定仓库管理员审核人
        @LogInfo(methodName = "updateRepository")
        @RequestMapping(value = "/updateRepository")
        @ResponseBody
        public ResponseMessage updateRepository(@RequestBody String requestBody) {
            JSONObject requestJson = JSONObject.parseObject(requestBody);
            String id = requestJson.getString("id");
            String name = requestJson.getString("name");
            int flag = banGongService.updateRepository(id,name);
            if (flag != 1) {
                return new ResponseMessage(Code.CODE_ERROR, "指定办公室审核人失败");
            }
            return new ResponseMessage(Code.CODE_OK, "指定办公室审核人成功");
        }
        //指定采购员
        @LogInfo(methodName = "updatePucharse")
        @RequestMapping(value = "/updatePucharse")
        @ResponseBody
        public ResponseMessage updatePucharse(@RequestBody String requestBody) {
            JSONObject requestJson = JSONObject.parseObject(requestBody);
            String id = requestJson.getString("id");
            String name = requestJson.getString("name");
            int flag = banGongService.updatePucharse(id,name);
            if (flag != 1) {
                return new ResponseMessage(Code.CODE_ERROR, "指定采购员人失败");
            }
            return new ResponseMessage(Code.CODE_OK, "指定采购员人成功");
        }*/


    //查询办公用品名称领用列表
    @LogInfo(methodName = "querySupplyNames")
    @RequestMapping(value = "/querySupplyNames")
    @ResponseBody
    public ResponseMessage querySupplyNames() {
        try {
            logger.error(tag + "querySupplyNames() begin");
            List<TXietongSupplyRecord> supplyRecords = banGongService.queryAllSupplyNames();
            return new ResponseMessage(Code.CODE_OK, "查询办公用品名称领用列表", supplyRecords);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(tag + "querySupplyNames()", e);
            return new ResponseMessage(Code.CODE_ERROR, "服务器异常", e);
        }
    }

    //查询领用部门领用列表
    @LogInfo(methodName = "queryDepartNames")
    @RequestMapping(value = "/queryDepartNames")
    @ResponseBody
    public ResponseMessage queryDepartNames() {
        try {
            logger.error(tag + "deleteName() begin");
            List<TXietongSupplyRecord> departNames = banGongService.queryAllDepartNames();
            return new ResponseMessage(Code.CODE_OK, "查询部门领用列表", departNames);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(tag + "queryDepartNames()", e);
            return new ResponseMessage(Code.CODE_ERROR, "服务器异常", e);
        }
    }

    //查询办公用品年份领用列表
    @LogInfo(methodName = "querySupplyYears")
    @RequestMapping(value = "/querySupplyYears")
    @ResponseBody
    public ResponseMessage querySupplyYears() {
        try {
            logger.error(tag + "querySupplyYears() begin");
            List<String> years = banGongService.querySupplyYears();
            return new ResponseMessage(Code.CODE_OK, "查询办公用品名称领用列表", years);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(tag + "querySupplyYears()", e);
            return new ResponseMessage(Code.CODE_ERROR, "服务器异常", e);
        }
    }


    @LogInfo(methodName = "analysisResult")
    @RequestMapping(value = "/analysisResult")
    @ResponseBody
    public ResponseMessage analysisResult(@RequestBody String requestBody){
        try {
            logger.error(tag + "analysisResult() begin...requestBody", requestBody);
            JSONObject requestJson = JSONObject.parseObject(requestBody);
            JSONArray supplyNames = requestJson.getJSONArray("supplyNames");
            JSONArray departNames = requestJson.getJSONArray("departNames");
            //如果是0，按照数量进行统计  如果是1，按照金额
            Integer type = requestJson.getInteger("type");
            JSONArray years = requestJson.getJSONArray("years");
            JSONArray months = requestJson.getJSONArray("months");
            Map collection = new HashMap<String, List<TXietongSupplyRecord>>();
            //1:先拼时间
            //如果年和月都为空   年不空 ，月为空   ，年合月都不空
            //年不为空
            if (years.size() != 0) {
                //如果部门为空
                if (departNames == null || departNames.size() == 0) {
                    departNames = new JSONArray();
                    int i = 0;
                    List<TXietongSupplyRecord> departNames1 = banGongService.queryAllDepartNames();
                    //遍历添加部门
                    for (TXietongSupplyRecord departname : departNames1) {
                        departNames.set(i, departname.getReceiptorDepartName());
                        i++;
                    }
                }
                if (supplyNames == null || supplyNames.size() == 0) {
                    supplyNames = new JSONArray();
                    int u = 0;
                    List<TXietongSupplyRecord> supplyRecords = banGongService.queryAllSupplyNames();
                    for (TXietongSupplyRecord supplyRecord : supplyRecords) {
                        supplyNames.set(u, supplyRecord.getSupplyName());
                        u++;
                    }
                }
                for (Object year : years) {
                    //  如果月不等于空
                    if (months.size() != 0) {
                        // ====================================办公用品数量大于1  x显示办公用品名称，纵轴数量汇总===================================================
                  /*  if(supplyNames!=null){*/
                        int sum1 = 0;
                        if (supplyNames.size() != 1) {

                       /* List<TXietongSupplyRecord> BestList = new ArrayList<>();*/
                            for (Object supplyName : supplyNames) {
                                for (Object departName : departNames) {
                                    Integer all = 0;
                                    double allPrice1 = 0;
                                    for (Object month : months) {
                                        String ym = year.toString() + month;
                                        List<TXietongSupplyRecord> lists = banGongService.querySupplyRecord(supplyName.toString(), departName.toString(), ym);
                                        for (TXietongSupplyRecord list : lists) {
                                            List<TXietongSupplyRecord> newList = new ArrayList<>();
                                            int amount = list.getAmount();
                                            all = all + amount;
                                         /*   double price = list.getPrice();
                                            allPrice1 = (allPrice1 + price * amount);
                                            list.setAllPrice(allPrice1);*/
                                       /* sum1 = amount + sum1;*/
                                            list.setAllAmount(all);
                                            list.setSupplyName(supplyName.toString());
                                            list.setDepartMent(departName.toString());
                                            list.setYm(ym);
                                            //办公用品数量大于1，并且多个处室  类型为2；
                                            list.setInterfacetype(2);
                                            list.setX(supplyName.toString());
                                            list.setLittleValue(departName.toString());
                                            newList.add(list);
                                            List<TXietongSupplyRecord> getList = (List<TXietongSupplyRecord>) collection.get(supplyName);
                                            if (!CollectionUtils.isEmpty(getList)) {
                                                for (int y = 0; y < getList.size(); y++) {
                                                    TXietongSupplyRecord supplyRecord = getList.get(y);
                                                    String departName1 = supplyRecord.getReceiptorDepartName();
                                                    if ((departName.toString()).equals(departName1)) {
                                                        getList.remove(y);
                                                        getList.addAll(newList);
                                                    } else {
                                                   /* c=0代表没有，c=1代表有一个*/
                                                        int c = 0;
                                                        for (int z = 0; z < getList.size(); z++) {
                                                            if (departName.equals(getList.get(z).getReceiptorDepartName())) {
                                                                c = 1;
                                                            }
                                                        }
                                                        // 如果集合里面包含了这个数据  就不添加  不包含就添加
                                                        //c=0说明没有  添加  有就不添加
                                                        if (c == 0) {
                                                            getList.addAll(newList);
                                                        }
                                                    }
                                                }
                                            } else {
                                                collection.put(supplyName, newList);
                                            }
                                        }
                                    }

                                }
                          /*  all=0;
                            allPrice1=0;*/
                            }

                            return new ResponseMessage(Code.CODE_OK, "查询信息", collection);
                        /* int bestamount=0;
                        Map<String,Integer> map=new HashMap<>();
                        for (TXietongSupplyRecord record:BestList) {
                           int amount= record.getAmount();
                           bestamount=amount+bestamount;
                           map.put(record.getSupplyName(),bestamount);
                        }*/

                        }
                        //
                        //办公用品长度为1
                        else {
                        /* for (Object month : months) {
                            for (Object departName : departNames) {
                                for (Object supplyName : supplyNames) {
                                    String ym = year.toString() + month;
                                    List<TXietongSupplyRecord> lists = banGongService.querySupplyRecord(supplyName.toString(), departName.toString(), ym);
                                    for (TXietongSupplyRecord list : lists) {
                                        int amount = list.getAmount();
                                        amount = amount + sum;
                                        list.getCreatetime();
                                        collection.put(ym, amount);
                                    }
                                }
                            }
                        }*/

                            for (Object month : months) {
                                for (Object departName : departNames) {
                                    int sum4 = 0;
                                    double allprice4 = 0;
                                    for (Object supplyName : supplyNames) {
                                        String ym = year.toString() + month;
                                        List<TXietongSupplyRecord> lists = banGongService.querySupplyRecord(supplyName.toString(), departName.toString(), ym);
                                        for (TXietongSupplyRecord list : lists) {
                                            List<TXietongSupplyRecord> newList = new ArrayList<>();
                                            int amount = list.getAmount();
                                            sum4 = amount + sum4;
                                            list.setAllAmount(sum4);
                                            /*  double price = list.getPrice();
                                            allprice4 += (allprice4 + price * amount);
                                            list.setAllPrice(allprice4);*/
                                            list.setYm(ym);
                                            list.setDepartMent(departName.toString());
                                            //第二种情况   办公用品数量为1
                                            list.setInterfacetype(1);
                                            list.setX(ym);
                                            list.setLittleValue(departName.toString());
                                            list.setSize(departNames.size());
                                            newList.add(list);
                                            List<TXietongSupplyRecord> getList = (List<TXietongSupplyRecord>) collection.get(ym);
                                            if (!CollectionUtils.isEmpty(getList)) {
                                                for (int y = 0; y < getList.size(); y++) {
                                                    TXietongSupplyRecord supplyRecord = getList.get(y);
                                                    String department2 = supplyRecord.getDepartMent();
                                                    if ((departName.toString()).equals(department2)) {
                                                        getList.remove(y);
                                                        getList.addAll(newList);
                                                    } else {
                                                     /* c=0代表没有，c=1代表有一个*/
                                                        int c = 0;
                                                        for (int z = 0; z < getList.size(); z++) {
                                                            if (departName.equals(getList.get(z).getReceiptorDepartName())) {
                                                                c = 1;
                                                            }
                                                        }
                                                        // 如果集合里面包含了这个数据  就不添加  不包含就添加
                                                        //c=0说明没有  添加  有就不添加
                                                        if (c == 0) {
                                                            getList.addAll(newList);
                                                        }

                                                    }
                                                }
                                            } else {
                                                collection.put(ym, newList);
                                            }
                                        }
                                    }
                                /*sum4=0;
                                allprice4=0;*/
                                }
                            }
                        }

                        //月份为空 查询的是所有的
                    } else if (months.size() == 0) {
                   /* months.set(0, "01");
                    months.set(1, "02");
                    months.set(2, "03");
                    months.set(3, "04");
                    months.set(4, "05");
                    months.set(5, "06");
                    months.set(6, "07");
                    months.set(7, "08");
                    months.set(8, "09");
                    months.set(9, "10");
                    months.set(10, "11");
                    months.set(11, "12");*/

                        if (supplyNames.size() != 1) {
                            if (supplyNames.size() == 0) {
                                int j = 0;
                                List<TXietongSupplyRecord> supplyRecords = banGongService.queryAllSupplyNames();
                                for (TXietongSupplyRecord supplyRecord : supplyRecords) {
                                    supplyNames.set(j, supplyRecord.getSupplyName());
                                    j++;
                                }
                            }
                            //+++++++++++++++++++++++++++月份没有选  但是多个办公用品++++++++++++++++++++++++++++++
                     /*   for (Object month : months) {*/
                            for (Object supplyName : supplyNames) {
                                for (Object departName : departNames) {
                                    int sum1 = 0;
                                    double allprice1 = 0;
                                    String ym = year.toString();
                                    List<TXietongSupplyRecord> lists = banGongService.querySupplyRecord(supplyName.toString(), departName.toString(), ym);
                                    for (TXietongSupplyRecord list : lists) {
                                        List<TXietongSupplyRecord> newList = new ArrayList<>();
                                        int amount = list.getAmount();
                                        sum1 = amount + sum1;
                                        list.setAllAmount(sum1);
                                      /*  double price = list.getPrice();
                                        allprice1 = (allprice1 + price * amount);
                                        list.setAllPrice(allprice1);*/
                                        list.setSupplyName(supplyName.toString());
                                        list.setDepartMent(departName.toString());
                                        //办公用品数量大于1，并且多个处室  类型为2;
                                        list.setInterfacetype(2);
                                        list.setX(supplyName.toString());
                                        list.setLittleValue(departName.toString());
                                        newList.add(list);
                                        List<TXietongSupplyRecord> getList = (List<TXietongSupplyRecord>) collection.get(supplyName);
                                        if (!CollectionUtils.isEmpty(getList)) {
                                            for (int y = 0; y < getList.size(); y++) {
                                                TXietongSupplyRecord supplyRecord = getList.get(y);
                                                String departName2 = supplyRecord.getDepartMent();
                                                if ((departName.toString()).equals(departName2)) {
                                                    getList.remove(y);
                                                    getList.addAll(newList);
                                                } else {
                                                    /* c=0代表没有，c=1代表有一个*/
                                                    int c = 0;
                                                    for (int z = 0; z < getList.size(); z++) {
                                                        if (departName.equals(getList.get(z).getReceiptorDepartName())) {
                                                            c = 1;
                                                        }
                                                    }
                                                    // 如果集合里面包含了这个数据  就不添加  不包含就添加
                                                    //c=0说明没有  添加  有就不添加
                                                    if (c == 0) {
                                                        getList.addAll(newList);
                                                    }
                                                }
                                            }
                                        } else {
                                            collection.put(supplyName, newList);
                                        }
                                    }
                                }
                              /*  sum1=0;
                            allprice1=0;*/
                            }

                        /*//遍历完 清理月份  等下一次循环
                        months.clear();*/
                        }
                        //办公用品长度为1
                        else {
                      /*  for (Object month : months) {*/
                            for (Object departName : departNames) {
                                int sum3 = 0;
                                double allPrice3 = 0;
                                for (Object supplyName : supplyNames) {
                                    String ym = year.toString();
                                    List<TXietongSupplyRecord> lists = banGongService.querySupplyRecord(supplyName.toString(), departName.toString(), ym);
                                    for (TXietongSupplyRecord list : lists) {
                                        List<TXietongSupplyRecord> newList = new ArrayList<>();
                                        int amount = list.getAmount();
                                        sum3 = amount + sum3;
                                        /*double price = list.getPrice();
                                        allPrice3 = (allPrice3 + price * amount);
                                          list.setAllPrice(allPrice3);*/
                                        list.setAllAmount(sum3);
                                        list.setYm(ym);

                                        list.setDepartMent(departName.toString());
                                        //第二种情况   办公用品数量为1
                                        list.setInterfacetype(1);
                                        list.setX(ym);
                                        list.setLittleValue(departName.toString());
                                        list.setSize(departNames.size());
                                        newList.add(list);
                                        List<TXietongSupplyRecord> getList = (List<TXietongSupplyRecord>) collection.get(ym);
                                        if (!CollectionUtils.isEmpty(getList)) {
                                            for (int y = 0; y < getList.size(); y++) {
                                                TXietongSupplyRecord supplyRecord = getList.get(y);
                                                String department2 = supplyRecord.getDepartMent();
                                                if ((departName.toString()).equals(department2)) {
                                                    getList.remove(y);
                                                    getList.addAll(newList);
                                                } else {
                                                    /* c=0代表没有，c=1代表有一个*/
                                                    int c = 0;
                                                    for (int z = 0; z < getList.size(); z++) {
                                                        if (departName.equals(getList.get(z).getReceiptorDepartName())) {
                                                            c = 1;
                                                        }
                                                    }
                                                    // 如果集合里面包含了这个数据  就不添加  不包含就添加
                                                    //c=0说明没有  添加  有就不添加
                                                    if (c == 0) {
                                                        getList.addAll(newList);
                                                    }
                                                }
                                            }
                                        } else {
                                            collection.put(ym, newList);
                                        }
                                    }
                                }
                              /*  sum=0;
                                allPrice=0;*/
                            }
                      /*  //遍历完 清理月份  等下一次循环
                        months.clear();*/

                      /*  return new ResponseMessage(Code.CODE_OK, "查询信息", array);*/
                        }
                    }
                }
                return new ResponseMessage(Code.CODE_OK, "查询信息", collection);
                //如果年为空   此时一定是没有月份的  所以是没有选择时间的情况
                //横轴是处室名称  纵轴是数量
            } else {
                String ym = null;
                //如果部门为空
                if (departNames == null || departNames.size() == 0) {
                    departNames = new JSONArray();
                    int x = 0;
                    List<TXietongSupplyRecord> departNames1 = banGongService.queryAllDepartNames();
                    for (TXietongSupplyRecord departname : departNames1) {
                        departNames.set(x, departname.getReceiptorDepartName());
                        x++;
                    }
                }
                //如果年份为空  用品也为空
                if (supplyNames == null || supplyNames.size() == 0) {
                    supplyNames = new JSONArray();
                    int u = 0;
                    List<TXietongSupplyRecord> supplyRecords = banGongService.queryAllSupplyNames();
                    for (TXietongSupplyRecord supplyRecord : supplyRecords) {
                        supplyNames.set(u, supplyRecord.getSupplyName());
                        u++;
                    }
                }

                for (Object departName : departNames) {
                    for (Object supplyName : supplyNames) {
                        int sum2 = 0;
                        int size = 1;
                        double allprice3 = 0;

                        List<TXietongSupplyRecord> TXietongSupplyRecords = banGongService.querySupplyRecord(supplyName.toString(), departName.toString(), ym);
                        for (TXietongSupplyRecord supplyRecord : TXietongSupplyRecords) {
                            List<TXietongSupplyRecord> newList = new ArrayList<>();
                            int amount = supplyRecord.getAmount();
                            sum2 = amount + sum2;
                           /* double price = supplyRecord.getPrice();
                            allprice3 = (allprice3 + price * amount);
                            supplyRecord.setAllPrice(allprice3);*/
                            supplyRecord.setAllAmount(sum2);
                            supplyRecord.setDepartMent(departName.toString());
                            supplyRecord.setSupplyName(supplyName.toString());
                            supplyRecord.setInterfacetype(0);
                            supplyRecord.setX(departName.toString());
                            supplyRecord.setLittleValue(supplyName.toString());
                            supplyRecord.setSize(size++);
                            newList.add(supplyRecord);
                            List<TXietongSupplyRecord> getList = (List<TXietongSupplyRecord>) collection.get(departName.toString());
                            if (!CollectionUtils.isEmpty(getList)) {
                                for (int y = 0; y < getList.size(); y++) {
                                    TXietongSupplyRecord supplyRecord1 = getList.get(y);
                                    //这是集合里面的值
                                    String supplyName1 = supplyRecord1.getSupplyName();
                                    if ((supplyName.toString()).equals(supplyName1)) {
                                        getList.remove(y);
                                        getList.addAll(newList);
                                        //如果不相同
                                    } else {
                                   /* c=0代表没有，c=1代表有一个*/
                                        int c = 0;
                                        for (int z = 0; z < getList.size(); z++) {
                                            if (supplyName.equals(getList.get(z).getSupplyName())) {
                                                c = 1;
                                            }
                                        }
                                        // 如果集合里面包含了这个数据  就不添加  不包含就添加
                                        //c=0说明没有  添加  有就不添加
                                        if (c == 0) {
                                            getList.addAll(newList);
                                        }
                                    }
                                }
                            } else {
                                //如果这个部门，没有有相关记录就添加  有了 累加newList
                                collection.put(departName, newList);
                            }
                        }
                    }
                }
                return new ResponseMessage(Code.CODE_OK, "查询处室和总量", collection);
            /*if(list.size()!=0)
            { collection.put(ym, list);}
            return new ResponseMessage(Code.CODE_OK,"查询信息成功",collection);*/

            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(tag + "analysisResult()", e);
            return new ResponseMessage(Code.CODE_ERROR, "服务器异常", e);
        }
    }

    @LogInfo(methodName = "queryAll")
    @RequestMapping(value = "/queryAll")
    @ResponseBody
    public ResponseMessage queryAll(@RequestBody String requestBody) {
        try {
            logger.error(tag + "queryAll() begin...requestBody");
            JSONObject requestJson = JSONObject.parseObject(requestBody);
            String pageNum = requestJson.getString("pageNum");
            String pageCount = requestJson.getString("pageCount");
            Page<TXietongSuppliesApply> page = new Page<>();
            int totalCount = banGongService.getCountAll();
            page.init(totalCount, Integer.valueOf(pageNum), Integer.valueOf(pageCount));
            List<TXietongSuppliesApply> listAll = banGongService.queryAll(page.getRowNum(), page.getPageCount());
            page.setList(listAll);
            return new ResponseMessage(Code.CODE_OK, "查询所有信息", page);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(tag + "analysisResult()", e);
            return new ResponseMessage(Code.CODE_ERROR, "服务器异常", e);
        }
    }

    //上传图片
    @RequestMapping(value = "/uploadCailiao", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage uploadSuperVision(MultipartFile[] files) {
        logger.debug(tag + "uploadCailiao()files#################### " + files);
        StringBuffer file_path = new StringBuffer();
        try {
            for (int i = 0; i < files.length; i++) {
                MultipartFile file = files[i];
                file_path.append(upload.uploadFlie(file));
                logger.debug(tag + "uploadCailiao()file_path#################### " + file_path);
                if (file_path.toString().equals("1")) {
                    return new ResponseMessage(Code.CODE_ERROR, "error", "上传失败");
                }
                file_path = file_path.append("^");
                logger.debug(tag + "uploadCailiao()file_path2#################### " + file_path);
            }
            if (!StringUtils.isEmpty(file_path)) {
                return new ResponseMessage(Code.CODE_OK, "success", file_path);
            }
            return new ResponseMessage(Code.CODE_ERROR, "error", "上传失败");
        } catch (Exception e) {
            logger.debug(tag + "uploadCailiao()error#################### ", e);
            return new ResponseMessage(Code.CODE_ERROR, "error", "上传失败");
        }
    }

    @LogInfo(methodName = "updateRecord")
    @RequestMapping(value = "/updateRecord")
    @ResponseBody
    public ResponseMessage updateRecord(@RequestBody String requestBody) {
        JSONObject requestJson = JSONObject.parseObject(requestBody);
        String id = requestJson.getString("id");
        Integer opinion = requestJson.getInteger("opinion");
        String ownerId = requestJson.getString("ownerId");
        String ownerName = requestJson.getString("ownerName");
        String nextPeopleId = requestJson.getString("nextPeopleId");
        String nextPeopleName = requestJson.getString("nextPeopleName");
        String content = requestJson.getString("content");
        Long bangongshiId = banGongService.queryBanGongId();
        String banggongshiId1 = bangongshiId.toString();

        //办公室的id和下一个审核人id不相等  发给别人  生成一条新的记录
        if (!banggongshiId1.equals(nextPeopleId)) {
            TXietongSuppliesApplyRecord applyRecord = new TXietongSuppliesApplyRecord();
            applyRecord.setId(UUID.randomUUID().toString());
            applyRecord.setApplyId(id);
            applyRecord.setOwnerId(nextPeopleId);
            applyRecord.setOwnerName(nextPeopleName);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            Date time = null;
            try {
                time = sdf.parse(sdf.format(new Date()));
            } catch (Exception e) {
                logger.debug("转换时间格式出错", e);
                e.printStackTrace();
                return new ResponseMessage(Code.CODE_ERROR, "时间转换错误");
            }
            applyRecord.setCreatetime(time);
            applyRecord.setIsdelete(0);
            applyRecord.setStatus(0);
            //applytype为0  代表用品审批
            applyRecord.setApplyType(0);
            int f = banGongService.addApplyRecords(applyRecord);
            if (f != 1) {
                return new ResponseMessage(Code.CODE_ERROR, "指定审核人失败");
            }
            //生成通知
            daibanUtil.insertDaibanRecord(applyRecord.getId(), content, "bgyp0", applyRecord.getOwnerId());
        } else {
            int f = banGongService.updateBanGongshiStatus(id, nextPeopleId);
            if (f != 1) {
                return new ResponseMessage(Code.CODE_ERROR, "更新发起人状态失败");
            }
        }
        TXietongSuppliesApplyRecord Record = new TXietongSuppliesApplyRecord();
        Record.setApplyId(id);
        Record.setOwnerId(ownerId);
        Record.setOpinion(opinion);
        //isParallel为1:已经处理
        Record.setIsParallel(1);
        int f2 = banGongService.updateOfficerRecord(Record);
        String recordId = banGongService.queryRecordIdBanGong(id, ownerId);
        daibanUtil.UpdateDaibanRecord(recordId);
        if (f2 == 1) {
            return new ResponseMessage(Code.CODE_OK, "更新审批意见成功");
        } else {
            return new ResponseMessage(Code.CODE_ERROR, "更新失败");
        }
    }

    @LogInfo(methodName = "print")
    @RequestMapping(value = "/print")
    @ResponseBody
    public ResponseMessage print(@RequestBody String requestBody) {
        JSONObject requestJson = JSONObject.parseObject(requestBody);
        String id = requestJson.getString("id");
        TXietongSuppliesApply suppliesApply = banGongService.print(id);
        if (suppliesApply == null) {
            return new ResponseMessage(Code.CODE_ERROR, "查询打印信息失败");
        }
        return new ResponseMessage(Code.CODE_OK, "查询打印信息成功", suppliesApply);
    }
    @LogInfo(methodName = "queryAttribute")
    @RequestMapping(value = "/queryAttribute")
    @ResponseBody
    public ResponseMessage queryAttribute(@RequestBody String requestBody) {
        JSONObject requestJson = JSONObject.parseObject(requestBody);
        String category = requestJson.getString("category");
        String name = requestJson.getString("name");
        String type = requestJson.getString("type");
        List<Integer> attributes=banGongService.queryAttribute(name,type);
        String attribute;
        if(attributes.size()!=0) {
             attribute = attributes.get(0).toString();
        }else {
            attribute="0";
        }
        return new ResponseMessage(Code.CODE_OK,"属性值",attribute);
    }



}



