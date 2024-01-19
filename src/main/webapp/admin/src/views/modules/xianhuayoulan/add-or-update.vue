<template>
  <div class="addEdit-block">
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
	  :style="{backgroundColor:addEditForm.addEditBoxColor}"
    >
      <el-row>
                        <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="鲜花名称" prop="xianhuamingcheng">
          <el-input v-model="ruleForm.xianhuamingcheng" 
              placeholder="鲜花名称" clearable  :readonly="ro.xianhuamingcheng"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="鲜花名称" prop="xianhuamingcheng">
              <el-input v-model="ruleForm.xianhuamingcheng" 
                placeholder="鲜花名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="select" v-if="type!='info'"  label="鲜花分类" prop="xianhuafenlei">
          <el-select v-model="ruleForm.xianhuafenlei" placeholder="请选择鲜花分类">
            <el-option
                v-for="(item,index) in xianhuafenleiOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="鲜花分类" prop="xianhuafenlei">
	      <el-input v-model="ruleForm.xianhuafenlei"
                placeholder="鲜花分类" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="select" v-if="type!='info'"  label="鲜花用途" prop="xianhuayongtu">
          <el-select v-model="ruleForm.xianhuayongtu" placeholder="请选择鲜花用途">
            <el-option
                v-for="(item,index) in xianhuayongtuOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="鲜花用途" prop="xianhuayongtu">
	      <el-input v-model="ruleForm.xianhuayongtu"
                placeholder="鲜花用途" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="select" v-if="type!='info'"  label="赠送对象" prop="zengsongduixiang">
          <el-select v-model="ruleForm.zengsongduixiang" placeholder="请选择赠送对象">
            <el-option
                v-for="(item,index) in zengsongduixiangOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="赠送对象" prop="zengsongduixiang">
	      <el-input v-model="ruleForm.zengsongduixiang"
                placeholder="赠送对象" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="24">  
        <el-form-item class="upload" v-if="type!='info' && !ro.tupian" label="图片" prop="tupian">
          <file-upload
          tip="点击上传图片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.tupian?ruleForm.tupian:''"
          @change="tupianUploadChange"
          ></file-upload>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.tupian" label="图片" prop="tupian">
            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.tupian.split(',')" :src="item" width="100" height="100">
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="相关花语" prop="xiangguanhuayu">
          <el-input v-model="ruleForm.xiangguanhuayu" 
              placeholder="相关花语" clearable  :readonly="ro.xiangguanhuayu"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="相关花语" prop="xiangguanhuayu">
              <el-input v-model="ruleForm.xiangguanhuayu" 
                placeholder="相关花语" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                                                  <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="商家账号" prop="shangjiazhanghao">

        <div v-else>
          <el-form-item class="input" label="商家账号" prop="shangjiazhanghao">
            <el-select v-model="ruleForm.shangjiazhanghao" placeholder="请选择 ">
              <el-option
                  v-for="(item,index) in shangjiazhanghaoptions"
                  v-bind:key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="店铺名" prop="dianpuming">
          <el-input v-model="ruleForm.dianpuming" 
              placeholder="店铺名" clearable  :readonly="ro.dianpuming"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="店铺名" prop="dianpuming">
              <el-input v-model="ruleForm.dianpuming" 
                placeholder="店铺名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="店铺地址" prop="dianpudizhi">
          <el-input v-model="ruleForm.dianpudizhi" 
              placeholder="店铺地址" clearable  :readonly="ro.dianpudizhi"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="店铺地址" prop="dianpudizhi">
              <el-input v-model="ruleForm.dianpudizhi" 
                placeholder="店铺地址" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="联系方式" prop="lianxifangshi">
          <el-input v-model="ruleForm.lianxifangshi" 
              placeholder="联系方式" clearable  :readonly="ro.lianxifangshi"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="联系方式" prop="lianxifangshi">
              <el-input v-model="ruleForm.lianxifangshi" 
                placeholder="联系方式" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="联系人" prop="lianxiren">
          <el-input v-model="ruleForm.lianxiren" 
              placeholder="联系人" clearable  :readonly="ro.lianxiren"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="联系人" prop="lianxiren">
              <el-input v-model="ruleForm.lianxiren" 
                placeholder="联系人" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                                                                                <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="价格" prop="price">
          <el-input v-model="ruleForm.price" 
              placeholder="价格" clearable  :readonly="ro.price"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="价格" prop="price">
              <el-input v-model="ruleForm.price" 
                placeholder="价格" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                              </el-row>
                                                                                                                                                                                                                                                                                                                                    <el-row>
            <el-col :span="24">
              <el-form-item v-if="type!='info'"  label="商品详情" prop="shangpinxiangqing">
                <editor 
                    style="min-width: 200px; max-width: 600px;"
                    v-model="ruleForm.shangpinxiangqing" 
                    class="editor" 
                    action="file/upload">
                </editor>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.shangpinxiangqing" label="商品详情" prop="shangpinxiangqing">
                    <span v-html="ruleForm.shangpinxiangqing"></span>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
                                                                                                                                    <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
        <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
        <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
    
    
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
  data() {
    let self = this
    var validateIdCard = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!checkIdCard(value)) {
        callback(new Error("请输入正确的身份证号码"));
      } else {
        callback();
      }
    };
    var validateUrl = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isURL(value)) {
        callback(new Error("请输入正确的URL地址"));
      } else {
        callback();
      }
    };
    var validateMobile = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isMobile(value)) {
        callback(new Error("请输入正确的手机号码"));
      } else {
        callback();
      }
    };
    var validatePhone = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isPhone(value)) {
        callback(new Error("请输入正确的电话号码"));
      } else {
        callback();
      }
    };
    var validateEmail = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isEmail(value)) {
        callback(new Error("请输入正确的邮箱地址"));
      } else {
        callback();
      }
    };
    var validateNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isNumber(value)) {
        callback(new Error("请输入数字"));
      } else {
        callback();
      }
    };
    var validateIntNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isIntNumer(value)) {
        callback(new Error("请输入整数"));
      } else {
        callback();
      }
    };
    return {
	  addEditForm: {"btnSaveFontColor":"#fff","selectFontSize":"14px","btnCancelBorderColor":"#DCDFE6","inputBorderRadius":"4px","inputFontSize":"14px","textareaBgColor":"#fff","btnSaveFontSize":"14px","textareaBorderRadius":"4px","uploadBgColor":"#fff","textareaBorderStyle":"solid","btnCancelWidth":"88px","textareaHeight":"120px","dateBgColor":"#fff","btnSaveBorderRadius":"4px","uploadLableFontSize":"14px","textareaBorderWidth":"1px","inputLableColor":"#606266","addEditBoxColor":"#fff","dateIconFontSize":"14px","btnSaveBgColor":"rgba(252, 201, 51, 1)","uploadIconFontColor":"#8c939d","textareaBorderColor":"#DCDFE6","btnCancelBgColor":"rgba(220, 223, 230, 1)","selectLableColor":"#606266","btnSaveBorderStyle":"solid","dateBorderWidth":"1px","dateLableFontSize":"14px","dateBorderRadius":"4px","btnCancelBorderStyle":"solid","selectLableFontSize":"14px","selectBorderStyle":"solid","selectIconFontColor":"#C0C4CC","btnCancelHeight":"44px","inputHeight":"40px","btnCancelFontColor":"rgba(81, 81, 81, 1)","dateBorderColor":"#DCDFE6","dateIconFontColor":"#C0C4CC","uploadBorderStyle":"solid","dateBorderStyle":"solid","dateLableColor":"#606266","dateFontSize":"14px","inputBorderWidth":"1px","uploadIconFontSize":"28px","selectHeight":"40px","inputFontColor":"#606266","uploadHeight":"148px","textareaLableColor":"#606266","textareaLableFontSize":"14px","btnCancelFontSize":"14px","inputBorderStyle":"solid","btnCancelBorderRadius":"4px","inputBgColor":"#fff","inputLableFontSize":"14px","uploadLableColor":"#606266","uploadBorderRadius":"4px","btnSaveHeight":"44px","selectBgColor":"#fff","btnSaveWidth":"88px","selectIconFontSize":"14px","dateHeight":"40px","selectBorderColor":"#DCDFE6","inputBorderColor":"#DCDFE6","uploadBorderColor":"#DCDFE6","textareaFontColor":"#606266","selectBorderWidth":"1px","dateFontColor":"#606266","btnCancelBorderWidth":"0px","uploadBorderWidth":"1px","textareaFontSize":"14px","selectBorderRadius":"4px","selectFontColor":"#606266","btnSaveBorderColor":"#409EFF","btnSaveBorderWidth":"0px"},
      id: '',
      type: '',
      ro:{
	xianhuamingcheng : false,
	xianhuafenlei : false,
	xianhuayongtu : false,
	zengsongduixiang : false,
	tupian : false,
	xiangguanhuayu : false,
	shangpinxiangqing : false,
	shangjiazhanghao : false,
	dianpuming : false,
	dianpudizhi : false,
	lianxifangshi : false,
	lianxiren : false,
	clicktime : false,
	clicknum : false,
	price : false,
      },
            ruleForm: {
                	        xianhuamingcheng: '',
	                        	        xianhuafenlei: '',
	                        	        xianhuayongtu: '',
	                        	        zengsongduixiang: '',
	                        	        tupian: '',
	                        	        xiangguanhuayu: '',
	                        	        shangpinxiangqing: '',
	                        	        shangjiazhanghao: '',
	                        	        dianpuming: '',
	                        	        dianpudizhi: '',
	                        	        lianxifangshi: '',
	                        	        lianxiren: '',
	                        	        clicktime: '',
	                        	                        	        price: '',
	                      },
                                      xianhuafenleiOptions: [],
                                xianhuayongtuOptions: [],
                                zengsongduixiangOptions: [],
                                                                                                                                                                              rules: {
                  xianhuamingcheng: [
                            { required: true, message: '鲜花名称不能为空', trigger: 'blur' },
                                    	                                                              ],
                  xianhuafenlei: [
                                    	                                                              ],
                  xianhuayongtu: [
                                    	                                                              ],
                  zengsongduixiang: [
                                    	                                                              ],
                  tupian: [
                                    	                                                              ],
                  xiangguanhuayu: [
                                    	                                                              ],
                  shangpinxiangqing: [
                                    	                                                              ],
                  shangjiazhanghao: [
                                    	                                                              ],
                  dianpuming: [
                                    	                                                              ],
                  dianpudizhi: [
                                    	                                                              ],
                  lianxifangshi: [
                                    	                                                              ],
                  lianxiren: [
                                    	                                                              ],
                  clicktime: [
                                    	                                                              ],
                  clicknum: [
                                        { validator: validateIntNumber, trigger: 'blur' },
                        	                                                              ],
                  price: [
                            { required: true, message: '价格不能为空', trigger: 'blur' },
                                                    { validator: validateNumber, trigger: 'blur' },
            	                                                              ],
              }
    };
  },
  props: ["parent"],
  computed: {
                                                                                                                                                                                          },
  created() {
	this.addEditStyleChange()
	this.addEditUploadStyleChange()
  },
  methods: {
        // 下载
    download(file){
      window.open(`${file}`)
    },
    // 初始化
    init(id,type) {
      if (id) {
        this.id = id;
        this.type = type;
      }
      if(this.type=='info'||this.type=='else'){
        this.info(id);
      }else if(this.type=='cross'){
        var obj = this.$storage.getObj('crossObj');
        for (var o in obj){
          	            if(o=='xianhuamingcheng'){
            this.ruleForm.xianhuamingcheng = obj[o];
	    this.ro.xianhuamingcheng = true;
            continue;
          }
	            	            if(o=='xianhuafenlei'){
            this.ruleForm.xianhuafenlei = obj[o];
	    this.ro.xianhuafenlei = true;
            continue;
          }
	            	            if(o=='xianhuayongtu'){
            this.ruleForm.xianhuayongtu = obj[o];
	    this.ro.xianhuayongtu = true;
            continue;
          }
	            	            if(o=='zengsongduixiang'){
            this.ruleForm.zengsongduixiang = obj[o];
	    this.ro.zengsongduixiang = true;
            continue;
          }
	            	            if(o=='tupian'){
            this.ruleForm.tupian = obj[o];
	    this.ro.tupian = true;
            continue;
          }
	            	            if(o=='xiangguanhuayu'){
            this.ruleForm.xiangguanhuayu = obj[o];
	    this.ro.xiangguanhuayu = true;
            continue;
          }
	            	            if(o=='shangpinxiangqing'){
            this.ruleForm.shangpinxiangqing = obj[o];
	    this.ro.shangpinxiangqing = true;
            continue;
          }
	            	            if(o=='shangjiazhanghao'){
            this.ruleForm.shangjiazhanghao = obj[o];
	    this.ro.shangjiazhanghao = true;
            continue;
          }
	            	            if(o=='dianpuming'){
            this.ruleForm.dianpuming = obj[o];
	    this.ro.dianpuming = true;
            continue;
          }
	            	            if(o=='dianpudizhi'){
            this.ruleForm.dianpudizhi = obj[o];
	    this.ro.dianpudizhi = true;
            continue;
          }
	            	            if(o=='lianxifangshi'){
            this.ruleForm.lianxifangshi = obj[o];
	    this.ro.lianxifangshi = true;
            continue;
          }
	            	            if(o=='lianxiren'){
            this.ruleForm.lianxiren = obj[o];
	    this.ro.lianxiren = true;
            continue;
          }
	            	            if(o=='clicktime'){
            this.ruleForm.clicktime = obj[o];
	    this.ro.clicktime = true;
            continue;
          }
	            	            if(o=='clicknum'){
            this.ruleForm.clicknum = obj[o];
	    this.ro.clicknum = true;
            continue;
          }
	            	            if(o=='price'){
            this.ruleForm.price = obj[o];
	    this.ro.price = true;
            continue;
          }
	                    }
                                                                                                                                                                                                                                                              }
            // 获取用户信息
      this.$http({
        url: `${this.$storage.get('sessionTable')}/session`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          var json = data.data;
                                                                                                                                                                                		if(json.shangjiazhanghao!=''&&json.shangjiazhanghao){
              		this.ruleForm.shangjiazhanghao = json.shangjiazhanghao
		}
                                  		if(json.dianpuming!=''&&json.dianpuming){
              		this.ruleForm.dianpuming = json.dianpuming
		}
                                  		if(json.dianpudizhi!=''&&json.dianpudizhi){
              		this.ruleForm.dianpudizhi = json.dianpudizhi
		}
                                  		if(json.lianxifangshi!=''&&json.lianxifangshi){
              		this.ruleForm.lianxifangshi = json.lianxifangshi
		}
                                  		if(json.lianxiren!=''&&json.lianxiren){
              		this.ruleForm.lianxiren = json.lianxiren
		}
                                                                                                } else {
          this.$message.error(data.msg);
        }
      });
                                                            this.$http({
              url: `option/xianhuafenlei/xianhuafenlei`,
              method: "get"
            }).then(({ data }) => {
              if (data && data.code === 0) {
                this.xianhuafenleiOptions = data.data;
              } else {
                this.$message.error(data.msg);
              }
            });
         
                                        this.xianhuayongtuOptions = "爱情,生日,开业,婚礼,节庆,探望,商业".split(',')
                                        this.zengsongduixiangOptions = "恋人,朋友,父母,同事,领导,客户".split(',')
                                                                                                                                                                                                                                  },
                                                                                                                                // 多级联动参数
                                                                                                                                                                  info(id) {
      this.$http({
        url: `xianhuayoulan/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
	//解决前台上传图片后台不显示的问题
	let reg=new RegExp('../../../upload','g')//g代表全部
	this.ruleForm.shangpinxiangqing = this.ruleForm.shangpinxiangqing.replace(reg,'../../../bishe/upload');
        } else {
          this.$message.error(data.msg);
        }
      });
    },
        // 提交
    onSubmit() {
                  // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                                                                                                                                                                                                                                                                                                                  this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `xianhuayoulan/${!this.ruleForm.id ? "save" : "update"}`,
            method: "post",
            data: this.ruleForm
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$message({
                message: "操作成功",
                type: "success",
                duration: 1500,
                onClose: () => {
                  this.parent.showFlag = true;
                  this.parent.addOrUpdateFlag = false;
                  this.parent.xianhuayoulanCrossAddOrUpdateFlag = false;
                  this.parent.search();
                  this.parent.contentStyleChange();
                }
              });
            } else {
              this.$message.error(data.msg);
            }
          });
        }
      });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.xianhuayoulanCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
                                                                        tupianUploadChange(fileUrls) {
                this.ruleForm.tupian = fileUrls;
				this.addEditUploadStyleChange()
            },
                                                                                                                                    	addEditStyleChange() {
	  this.$nextTick(()=>{
	    // input
	    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputFontColor
	      el.style.fontSize = this.addEditForm.inputFontSize
	      el.style.borderWidth = this.addEditForm.inputBorderWidth
	      el.style.borderStyle = this.addEditForm.inputBorderStyle
	      el.style.borderColor = this.addEditForm.inputBorderColor
	      el.style.borderRadius = this.addEditForm.inputBorderRadius
	      el.style.backgroundColor = this.addEditForm.inputBgColor
	    })
	    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputLableColor
	      el.style.fontSize = this.addEditForm.inputLableFontSize
	    })
	    // select
	    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectFontColor
	      el.style.fontSize = this.addEditForm.selectFontSize
	      el.style.borderWidth = this.addEditForm.selectBorderWidth
	      el.style.borderStyle = this.addEditForm.selectBorderStyle
	      el.style.borderColor = this.addEditForm.selectBorderColor
	      el.style.borderRadius = this.addEditForm.selectBorderRadius
	      el.style.backgroundColor = this.addEditForm.selectBgColor
	    })
	    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectLableColor
	      el.style.fontSize = this.addEditForm.selectLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
	      el.style.color = this.addEditForm.selectIconFontColor
	      el.style.fontSize = this.addEditForm.selectIconFontSize
	    })
	    // date
	    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateFontColor
	      el.style.fontSize = this.addEditForm.dateFontSize
	      el.style.borderWidth = this.addEditForm.dateBorderWidth
	      el.style.borderStyle = this.addEditForm.dateBorderStyle
	      el.style.borderColor = this.addEditForm.dateBorderColor
	      el.style.borderRadius = this.addEditForm.dateBorderRadius
	      el.style.backgroundColor = this.addEditForm.dateBgColor
	    })
	    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateLableColor
	      el.style.fontSize = this.addEditForm.dateLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
	      el.style.color = this.addEditForm.dateIconFontColor
	      el.style.fontSize = this.addEditForm.dateIconFontSize
	      el.style.lineHeight = this.addEditForm.dateHeight
	    })
	    // upload
	    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
	    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
	      el.style.width = this.addEditForm.uploadHeight
	      el.style.height = this.addEditForm.uploadHeight
	      el.style.borderWidth = this.addEditForm.uploadBorderWidth
	      el.style.borderStyle = this.addEditForm.uploadBorderStyle
	      el.style.borderColor = this.addEditForm.uploadBorderColor
	      el.style.borderRadius = this.addEditForm.uploadBorderRadius
	      el.style.backgroundColor = this.addEditForm.uploadBgColor
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.uploadHeight
	      el.style.color = this.addEditForm.uploadLableColor
	      el.style.fontSize = this.addEditForm.uploadLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
	      el.style.color = this.addEditForm.uploadIconFontColor
	      el.style.fontSize = this.addEditForm.uploadIconFontSize
	      el.style.lineHeight = iconLineHeight
	      el.style.display = 'block'
	    })
	    // 多文本输入框
	    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
	      el.style.height = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaFontColor
	      el.style.fontSize = this.addEditForm.textareaFontSize
	      el.style.borderWidth = this.addEditForm.textareaBorderWidth
	      el.style.borderStyle = this.addEditForm.textareaBorderStyle
	      el.style.borderColor = this.addEditForm.textareaBorderColor
	      el.style.borderRadius = this.addEditForm.textareaBorderRadius
	      el.style.backgroundColor = this.addEditForm.textareaBgColor
	    })
	    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
	      // el.style.lineHeight = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaLableColor
	      el.style.fontSize = this.addEditForm.textareaLableFontSize
	    })
	    // 保存
	    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
	      el.style.width = this.addEditForm.btnSaveWidth
	      el.style.height = this.addEditForm.btnSaveHeight
	      el.style.color = this.addEditForm.btnSaveFontColor
	      el.style.fontSize = this.addEditForm.btnSaveFontSize
	      el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
	      el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
	      el.style.borderColor = this.addEditForm.btnSaveBorderColor
	      el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnSaveBgColor
	    })
	    // 返回
	    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
	      el.style.width = this.addEditForm.btnCancelWidth
	      el.style.height = this.addEditForm.btnCancelHeight
	      el.style.color = this.addEditForm.btnCancelFontColor
	      el.style.fontSize = this.addEditForm.btnCancelFontSize
	      el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
	      el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
	      el.style.borderColor = this.addEditForm.btnCancelBorderColor
	      el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnCancelBgColor
	    })
	  })
	},
	addEditUploadStyleChange() {
		this.$nextTick(()=>{
		  document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
			el.style.width = this.addEditForm.uploadHeight
			el.style.height = this.addEditForm.uploadHeight
			el.style.borderWidth = this.addEditForm.uploadBorderWidth
			el.style.borderStyle = this.addEditForm.uploadBorderStyle
			el.style.borderColor = this.addEditForm.uploadBorderColor
			el.style.borderRadius = this.addEditForm.uploadBorderRadius
			el.style.backgroundColor = this.addEditForm.uploadBgColor
		  })
	  })
	},
  }
};
</script>
<style lang="scss">
.editor{
  height: 500px;
  
  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
}
.btn .el-button {
  padding: 0;
}
</style>
