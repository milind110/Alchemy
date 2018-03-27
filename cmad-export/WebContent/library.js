window.addEventListener("load", function() {
	document.getElementById("btn").addEventListener("click", function() {
		var isbn = document.getElementById("isbn").value;
		var url = "findBook?isbn=" + isbn;
		var xhr = new XMLHttpRequest();
		xhr.open("GET", url, true);
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var o = JSON.parse(xhr.responseText);
				console.log(o);
				document.getElementById("results").innerHTML = o.title
			}
		};
		xhr.send();
	});
});