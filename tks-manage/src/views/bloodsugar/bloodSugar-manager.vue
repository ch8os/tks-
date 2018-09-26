<template>
  <div class="disease-content">
    <i-form inline :label-width="80">
      <i-row>
        <i-form-item prop="usercode" inline label="用户标识">
          <i-input type="text" v-model="condition.usercode" placeholder="请输入检索用户标识">
          </i-input>
        </i-form-item>

        <i-form-item prop="devicesn" inline label="设备标识">
          <i-input type="text" v-model="condition.devicesn" placeholder="请输入检索设备标识">
          </i-input>
        </i-form-item>
        <i-form-item prop="testtime" inline label="测试时间">
          <i-date-picker format="yyyy-MM-dd" @on-change="getStartTime" type="datetime" placeholder="请选择开始时间" style="width: 160px"></i-date-picker>
        </i-form-item>
		<i-form-item prop="endDate" :label-width="5">
          <i-date-picker  format="yyyy-MM-dd" @on-change="getEndTime" type="datetime" placeholder="请选择结束时间" style="width: 160px"></i-date-picker>
        </i-form-item>
		
        <i-form-item :label-width="20">
          <i-button type="primary" @click="getOrganInfoList()" icon="ios-search">查询</i-button>
         <!-- <i-button type="primary" @click="showMask()"  icon="plus">新增</i-button>-->
        </i-form-item>
      </i-row>
      </i-form>
    <div>
      <i-table border stripe :loading="false" :columns="bloodSugarInfoColumns" :data="organInfoArray" class="disease_grid"></i-table>
    </div>
    <div style="margin: 10px;overflow: hidden">
      <div style="float: right;">
        <i-page :total="dataCount" :page-size="pageSize" :current.sync="currentPage" show-total
                @on-change="changePage"></i-page>
      </div>
    </div>

    <i-modal width="700px"
             :title="this.maskTitle"
             v-model="maskModal"
             :mask-closable="false"
             :closable="false" class-name="vertical-center-modal">
      <i-form ref="editFormItem" :model="editFormItem" :label-width="80" :rules="ruleValidate" >
        <i-row>
          <i-col span="12">
            <i-form-item label="用户标识" prop="usercode">
              <i-input placeholder="请输入用户标识" v-model="editFormItem.usercode"  style="width:180px"></i-input>
            </i-form-item>
          </i-col>
          <i-col span="12">
							<i-form-item label="微信用户openid" prop="openid">
	              <i-input placeholder="请输入用户标识" v-model="editFormItem.openid"  style="width:180px"></i-input>
	            </i-form-item>
          </i-col>
          </i-col>
        </i-row>
        <i-row>
          <i-col span="12">
          	<i-form-item label="设备标识" prop="devicesn">
              <i-input placeholder="请输入设备标识" v-model="editFormItem.devicesn"  style="width:180px"></i-input>
            </i-form-item>
          </i-col>
          <i-col span="9">
            <i-form-item label="血糖测试结果" prop="result">
             <i-input placeholder="请输入血糖测试结果" v-model="editFormItem.result"  style="width:180px"></i-input>
            </i-form-item>
          </i-col>
        </i-row>
        <i-row>
          <i-col span="12">
          	<i-form-item label="单位（1 mmol/l）" prop="unit">
              <i-input placeholder="请输入单位" v-model="editFormItem.unit"  style="width:180px"></i-input>
            </i-form-item>
          </i-col>
          <i-col span="9">
            <i-form-item label="测试时间" prop="testtime">
               <i-input placeholder="请输入测试时间" v-model="editFormItem.testtime"  style="width:180px"></i-input>
            </i-form-item>
          </i-col>
        </i-row>
        <i-row>
         <i-col span="12">
            <i-form-item label="数据来源" prop="source">
            	<i-input placeholder="请输入数据来源" v-model="editFormItem.source"  style="width:180px"></i-input>
            </i-form-item>
          </i-col>
       	   <i-col span="9">
        	<i-form-item label="创建时间" prop="createTime">
             	<i-input placeholder="请输入创建时间" v-model="editFormItem.createTime"  style="width:180px"></i-input>
            </i-form-item>
          </i-col>  
        </i-row>
      </i-form>
      <div slot="footer">
        <i-button type="primary" size="large" @click="saveOrganInfo">保存</i-button>
        <i-button type="ghost" @click="closeModal" size="large">关闭</i-button>
      </div>
    </i-modal>
  </div>
</template>

<script>
  import Cookies from 'js-cookie'
  import util from '@/libs/util'

  export default {
    name: 'bloodSugar-manager',
    data () {
      return {
        condition: {
          devicesn: '',//用户唯一标识
          testtime:'',//测试时间
		  endDate:'',//测试时间
          usercode:''//设备标识
        },
        maskOrganArray: [],//资源器官数据
        organInfoArray: [],//器官信息数据
        maskSysArray:[],
        maskRelModelArray:[],
        relModelArray:[],
        currentPage: 1,
        loading:false,
        emptyMask: {
          id: '',
          code:'',
          devicesn:'',
          usercode:'',
          openid:'',
          result:'',
          unit:'',
          testtime:'',
          foodStatus:'',
          source:'',
          createTime:''
        },
        headers: {
          token: Cookies.get('token')
        },
        maskTitle: '个人血糖信息维护',
        editFormItem: {},
        maskModal: false,
        // 初始化信息总条数
        dataCount: 0,
        // 每页显示多少条
        pageSize: 13,
        bloodSugarInfoColumns: [
          {
            title: '用户标识',
            key: 'usercode'
          },
          {
            title: '微信用户openid',
            key: 'openid',
          },
          {
            title: '设备标识',
            key: 'devicesn'
          },
          {
            title: '血糖测试结果',
            key: 'result'
          },
          {
            title: '单位（1 mmol/l)',
            key: 'unit'
          },
          {
            title: '测试时间',
            key: 'testtime',
			width:160,
			render: (h, params) => {
              return h('div', [
                h('strong', util.dateToFormat(params.row.testtime))
              ]);
            }
          },
		  {
            title: '血糖类型',
            key: 'type',
            render: (h, params) => {
              return h('div', [
                h('strong', this.getLabelByFoodStatus(params.row.foodstatus))
              ]);
            }
          }, 
		  {
            title: '数据来源',
            key: 'type',
            render: (h, params) => {
              return h('div', [
                h('strong', this.getLabelBySource(params.row.source))
              ]);
            }
          },         
           {
            title: '创建时间',
            key: 'createTime',
			width:150,
			render: (h, params) => {
              return h('div', [
                h('strong', util.dateToFormat(params.row.createTime))
              ]);
            }
          }
        ],
        ruleValidate: {
          usercode: [
            { required: true, message: '用户标识不能为空', trigger: 'blur' }
          ],
          devicesn: [
            { required: true, message: '设备标识不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
	getLabelByFoodStatus(foodstatus){
        let label = ''
        switch (foodstatus){
          case '0':
            label='餐前'
            break
          case '1':
            label='餐后'
            break
		  case '2':
            label='随机'
            break
          default:
        }
        return label
      },
	getLabelBySource(source){
        let label = ''
        switch (source){
          case '1':
            label='三诺推送'
            break
          case '2':
            label='手动获取'
            break
		  case '3':
            label='其他'
            break
          default:
        }
        return label
      },
      // 获取历史记录信息
      changePage (index) {
        this.getOrganInfoList(index)
      },
      getStartTime(starTime) {
        this.condition.testtime = starTime
      },
	  getEndTime(endTime) {
        this.condition.endDate = endTime
      },

      //弹出用户辑窗口
      showMask (rows) {
        this.editFormItem = JSON.parse(JSON.stringify(this.emptyMask));
        if (!!rows) {
          	let dataRow = JSON.parse(JSON.stringify(rows))
	        this.getOrganRelation(dataRow).then(function (res) {
	            this.editFormItem = dataRow;
	          }.bind(this))
         }
        this.maskModal = true
      },

      //获取器官数据
      /*getOrganList (query) {
        if (query !== '') {
          this.loading = true;
          this.$axios.ajax({
            method: 'get',
            url: '/model/getOrganList?key=' + query,
            data: {}
          }).then((res) => {
            this.loading = false;
            if (!!res.data.code && 10000 == res.data.code) {
              this.maskOrganArray = JSON.parse(JSON.stringify(res.data.data))
            } else {
              this.$Message.error(!!res.data && !!res.data.msg ? res.data.msg : '获取器官信息失败')
            }
          })
        }
      },*/
      getOrganRelation (item) {
        return new Promise(function (resolve, reject) {
          this.$axios.ajax({
            method: 'post',
            url: '/BloodSugar/getBSugarListByCondition',
            data: {}
          }).then((res) => {
            if (!!res.data.code && 10000 == res.data.code) {
              this.maskSysArray = res.data.data['sysInfo'];
              this.maskRelModelArray = res.data.data['relModelList'];
            } else {
              this.$Message.error(!!res.data && !!res.data.msg ? res.data.msg : '获取数据失败')
            }
            resolve(res)
          })
        }.bind(this))
      },
      //获取血糖信息
      getOrganInfoList (pageIndex) {
        this.organInfoArray = []
        if (isNaN(pageIndex)) {
          this.currentPage = 1
        }
        this.$axios.ajax({
          method: 'post',
          url: '/BloodSugar/getBSugarListByCondition',
          data: {
            'pageNum': !isNaN(pageIndex) ? pageIndex : 1,
            'pageSize': this.pageSize,
            'organInfo': {
				'testtime': this.condition.testtime.toString(),
              'devicesn': this.condition.devicesn,
              'usercode': this.condition.usercode,
			  'endDate':	this.condition.endDate.toString()
            }
          }
        }).then((res) => {
          if (!!res.data.code && 10000 == res.data.code) {
            let data = res.data.data
            this.dataCount = !!data['total'] ? data['total'] : 0
            this.organInfoArray = !!data['list'] ? data['list'] : []
          } else {
            this.$Message.error(!!res.data && !!res.data.message ? res.data.message : '获取血糖列表数据失败')
          }
        })
      },
      closeModal () {
        this.maskModal = false
      },
       //删除器官信息
	   delOrganInfo(rows) {
	       this.$Modal.confirm({
	          title: '确认信息',
	          content: '<p1>确认删除该器官？</p1>',
	          onOk: () => {
	            let organData = JSON.parse(JSON.stringify(rows))
	            this.$axios.ajax({
	              method: 'post',
	              url: '/BloodSugar/delBloodSugarInfo',
	              data: organData
	            }).then((res) => {
	              if (!!res.data.code && 10000 == res.data.code) {
	                this.$Message.success('删除成功')
	                this.getOrganInfoList()
	              } else {
	                this.$Message.error(!!res.data && !!res.data.msg ? res.data.msg : '删除失败')
	              }
	            })
	          },
	          onCancel: () => {
	            return;
	          }
	        })
	    },
	    
      //保存器官信息
      saveOrganInfo () {
        this.$refs['editFormItem'].validate((valid) => {
          if (valid) {
            this.$axios.ajax({
              method: 'post',
              url: '/BloodSugar/saveOrUpdateBloodSugarInfo',
              data: this.editFormItem
            }).then((res) => {
              if (!!res.data.code && 10000 == res.data.code) {
                this.$Message.success('保存器官信息成功')
                this.getOrganInfoList()
                this.maskModal = false
              } else {
                this.$Message.error(!!res.data && !!res.data.msg ? res.data.msg : '保存疾病信息失败')
              }
            })
          }
        })
      }
    },
    created () {
      this.getOrganInfoList()//获取器官信息列表
    }
  }
</script>

<style>
  .disease-content {
    width: 100%;
    height: 100%;
  }

  .disease_grid {
    height: calc(100vh - 300px);
    overflow: auto;
  }

  .vertical-center-modal {
    display: flex;
    align-items: center;
    justify-content: center;
  }

  .vertical-center-modal .ivu-modal {
    top: 0;
  }
</style>
