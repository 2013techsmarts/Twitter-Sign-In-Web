var width = 820;
var height= 580;
var left = (screen.width/2)-(width/2);
function loginTwitter() {
	window.open("http://127.0.0.1:8080/Twitter-Sign-In-Web/signin",
			"mywindow","menubar=0,resizable=0,scrollbars=no,width="+width+",height="+height+",status=0,toolbar=0,left="+left+",top=120");
}