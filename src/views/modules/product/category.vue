<template>
    <div>
        <el-tree :data="menus" :props="defaultProps" @node-click="handleNodeClick" :expand-on-click-node="false"
            show-checkbox node-key="catId" :default-expanded-keys="expandedKey" draggable :allow-drop="allowDrop">
            <span class="custom-tree-node" slot-scope="{ node, data }">
                <span>{{ node.label }}</span>
                <span>
                    <el-button v-if="node.level <= 2" type="text" size="mini" @click="() => append(data)">
                        Append
                    </el-button>
                    <el-button v-if="node.childNodes.length == 0" type="text" size="mini"
                        @click="() => remove(node, data)">
                        Delete
                    </el-button>
                    <el-button type="text" size="mini" @click="() => edit(data)">
                        Edit
                    </el-button>
                </span>
            </span>
        </el-tree>

        <el-dialog :title="title" :visible.sync="dialogVisible" width="30%" :close-on-click-modal="false">
            <el-form :model="category">
                <el-form-item label="分类名称">
                    <el-input v-model="category.name" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="图标">
                    <el-input v-model="category.icon" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="计量单位">
                    <el-input v-model="category.productUnit" autocomplete="off"></el-input>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="submitData()">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
//这里可以导入其他文件（比如:组件,工具js,第三方插件js,json文件,图片文件等等）
//例如:import 《组件名称》from '《组件路径》';

export default {
    //import 引入的组件需要注入到对象中才能使用
    components: {},
    props: {},
    data() {
        return {
            maxLevel: 0,
            title: "",
            category: { name: "", parentCid: 0, catLevel: 0, showStatus: 1, sort: 0, catId: null, icon: "", productUnit: "" },
            dialogType: "",
            dialogVisible: false,
            menus: [],
            expandedKey: [],
            defaultProps: {
                children: 'children',
                label: 'name'
            }
        };
    },
    methods: {
        handleNodeClick(data) {
            console.log(data);
        },
        getMenus() {
            this.$http({
                url: this.$http.adornUrl('/product/category/list/tree'),
                method: 'get'
            }).then(({ data }) => {
                this.menus = data.data
            })
        },
        countNodeLevel(node){
            if (node.children!=null && node.children.length > 0){
                for (let i = 0; i < node.children.length; i ++) {
                    if (node.children[i].catLevel > this.maxLevel){
                        this.maxLevel = node.children[i].catLevel;
                    }
                    this.countNodeLevel(node.children[i]);
                }
            }
        },
        allowDrop(draggingNode, dropNode, type) {
            this.countNodeLevel(draggingNode.data);
            let deep = this.maxLevel - draggingNode.data.catLevel + 1;
            if (type == "inner") {
                return deep + dropNode.level <= 3;
            } else{
                return (deep + dropNode.parent.level) <= 3;
            }

            
        },
        submitData() {
            if (this.dialogType == 'add') {
                this.addCategory();
            }
            if (this.dialogType == 'edit') {
                this.editCategory();
            }
        },
        editCategory() {
            var { catId, name, icon, productUnit } = this.category;

            this.$http({
                url: this.$http.adornUrl('/product/category/update'),
                method: 'post',
                data: this.$http.adornData({ catId, name, icon, productUnit }, false)
            }).then(({ data }) => {
                this.$message({
                    message: "修改成功",
                    type: "success"
                });
                this.dialogVisible = false;
                this.expandedKey = [this.category.parentCid];
                this.getMenus();
            });
        },
        append(data) {
            this.category = { name: "", parentCid: 0, catLevel: 0, showStatus: 1, sort: 0, catId: null, icon: "", productUnit: "" };
            this.title = "添加分类";
            this.dialogType = "add";
            this.dialogVisible = true;
            this.category.parentCid = data.catId;
            this.category.catLevel = data.catLevel * 1 + 1;
        },
        remove(node, data) {
            var ids = [data.catId];
            this.$confirm(`是否删除【${data.name}】菜单?`, '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                this.$http({
                    url: this.$http.adornUrl('/product/category/delete'),
                    method: 'post',
                    data: this.$http.adornData(ids, false)
                }).then(({ data }) => {
                    this.$message({
                        message: "删除成功",
                        type: "success"
                    });
                    this.expandedKey = [node.parent.data.catId];
                    this.getMenus();

                });
            }).catch(() => {

            });
        },
        edit(data) {
            this.title = "修改分类";
            this.dialogType = "edit";
            this.dialogVisible = true;

            this.$http({
                url: this.$http.adornUrl(`/product/category/info/${data.catId}`),
                method: 'get',
                params: this.$http.adornParams({})
            }).then(({ data }) => {
                this.category.name = data.data.name;
                this.category.catId = data.data.catId;
                this.category.icon = data.data.icon;
                this.category.productUnit = data.data.productUnit;
                this.category.parentCid = data.data.parentCid;
            })
        },
        addCategory() {
            this.$http({
                url: this.$http.adornUrl('/product/category/save'),
                method: 'post',
                data: this.$http.adornData(this.category, false)
            }).then(({ data }) => {
                this.$message({
                    message: "保存成功",
                    type: "success"
                });
                this.dialogVisible = false;
                this.expandedKey = [this.category.parentCid];
                this.getMenus();
            });
        },
    },
    //计算属性类似于data 概念
    computed: {},
    //监控data 中的数据变化
    watch: {},
    //生命周期- 创建完成（可以访问当前this 实例）
    created() {
        this.getMenus();
    },
    //生命周期- 挂载完成（可以访问DOM 元素）
    mounted() {

    },
    beforeCreate() { }, //生命周期- 创建之前
    beforeMount() { }, //生命周期- 挂载之前
    beforeUpdate() { }, //生命周期- 更新之前
    updated() { }, //生命周期- 更新之后
    beforeDestroy() { }, //生命周期- 销毁之前
    destroyed() { }, //生命周期- 销毁完成
    activated() { }, //如果页面有keep-alive 缓存功能,这个函数会触发
}
</script>
<style lang='scss' scoped>
//@import url(); 引入公共css 类
</style>