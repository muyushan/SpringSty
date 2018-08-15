/**
 * 在给定的元素ID{selector} 上展现一个 tooltip
 * @param selector 要展现tooltip的元素id
 * @param text 要展示的文本
 * @param position tooltip 基于selector所指定的元素的位置：left/right/top/bottom
 */
function showToolTip(selector,text,position) {
    if(position==''||position==null){
        position="right";
    }else if(position!='left'&&position!='right'&&position!='top'&&position!='bottom'){
        position="right";
    }
    $('#'+selector).tooltip({animation:true,title:text,placement:position});
    $('#'+selector).tooltip('show');
    setTimeout(
        function(emelmentId){
            $('#'+emelmentId).tooltip('hide');
            $('#'+emelmentId).tooltip('dispose');
        },800,selector);
}

function formatDate(longDate){
    if(longDate==null||longDate==""){
        return "";
    }
    var  date =new Date();
    date.setTime(longDate);
    var year=date.getFullYear();
    var month=getMonth(date);
    var day=getDay(date);

    return year+"-"+month+"-"+day;

}

function formatDateTime(longDate){
    if(longDate==null||longDate==""){
        return "";
    }
    var result="";
    var  date =new Date();
    date.setTime(longDate);
    result=formatDate(date);

    var hour=getHour(date);
    var min=getMinute(date);
    var second=getSecond(date);
    result= result+"&nbsp;"+hour+":"+min+":"+second;
    return result;

}

function getMonth(date){
    var month = "";
    month = date.getMonth() + 1; //getMonth()得到的月份是0-11
    if(month<10){
        month = "0" + month;
    }
    return month;
}
function getDay(date){
    var day = "";
    day = date.getDate();
    if(day<10){
        day = "0" + day;
    }
    return day;
}

function getHour(date){
    var hours = "";
    hours = date.getHours();
    if(hours<10){
        hours = "0" + hours;
    }
    return hours;
}
function getMinute(date){
    var minute = "";
    minute = date.getMinutes();
    if(minute<10){
        minute = "0" + minute;
    }
    return minute;
}
function getSecond(date){
    var second = "";
    second = date.getSeconds();
    if(second<10){
        second = "0" + second;
    }
    return second;
}

function downFile(fileName){
var url=webRoot+"downloadFile/"+fileName+"/down.do";
    // $.get(url);
    var form = $("<form></form>").attr("action", url).attr("method", "post");
    form.appendTo('body').submit().remove();

}
