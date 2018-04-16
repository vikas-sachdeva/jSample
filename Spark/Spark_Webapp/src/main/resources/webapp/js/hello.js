function getIp() {
	$.get("../../getIp", function(data, status) {
		document.getElementById("container").innerHTML = data;
	});
}