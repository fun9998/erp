var dom = document.getElementById("container6");
var myChart = echarts.init(dom);
var app = {};
option = null;
app.title = '坐标轴刻度与标签对齐';

option = {
    color: ['#3398DB'],
    tooltip : {
        trigger: 'axis',
        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
        }
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis : [
        {
            type : 'category',
            data : ['北京', '杭州', '深圳', '上海', '南京', '成都', '西安', '广州', '武汉', '长沙'],
            axisTick: {
                alignWithLabel: true
            }
        }
    ],
    yAxis : [
        {
            type : 'value'
        }
    ],
    series : [
        {
            name:'平均薪资',
            type:'bar',
            barWidth: '60%',
            data:[25790, 23139, 22980, 20951, 17740, 15220, 15047, 14295, 13893, 12946]
        }
    ]
};
;
if (option && typeof option === "object") {
    myChart.setOption(option, true);
}