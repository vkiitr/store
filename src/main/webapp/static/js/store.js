function Hellofunc() {
	document.getElementById("demo").innerHTML = "Hello";
}

function readNumberOfApps() {
	var xhttp = new XMLHttpRequest();
	var appcountJson;
	xhttp.onreadystatechange = function() {
		if ((xhttp.readyState == 4) && (xhttp.status == 200)) {
			appcountJson = JSON.parse(xhttp.responseText);
			document.getElementById("appCount").innerHTML = appcountJson.totalAppCount;
		}
	};
	url = "app/count/";
	xhttp.open("GET", url);
	xhttp.setRequestHeader("Content-type", "application/json");
	xhttp.send(null);
}

function displayAllApps() {
	var xhttp = new XMLHttpRequest();
	var apps;
	var table = "";
	xhttp.onreadystatechange = function() {
		if ((xhttp.readyState == 4) && (xhttp.status == 200)) {
			apps = JSON.parse(xhttp.responseText);
			var i;
			for (i = 0; i < apps.length; i++) {
				table = document.getElementById("apptable").innerHTML;
				entry = generateTableEntry(apps[i]);
				document.getElementById("apptable").innerHTML = table + entry;
			}

		}
	};
	url = "app/list";
	xhttp.open("GET", url);
	xhttp.setRequestHeader("Content-type", "application/json");
	xhttp.send(null);
}

function generateTableEntry(appobj) {
	var entry;
	entry = "<tr>"
	entry += "<td>"
			+ "<span style=\"display:inline-block; width: 2px;\"></span>"
			+ appobj.sId + "</td>"
	entry += "<td>"
			+ "<span style=\"display:inline-block; width: 2px;\"></span>"
			+ "<a title=\"Show App details\" href=\"details?app="
			+ encodeURI(JSON.stringify(appobj)) + "\">" + appobj.name
			+ "</a></td>"
	entry += "<td>" + appobj.description + "</td>"
	entry += "<td>"
			+ "<span style=\"display:inline-block; width: 2px;\"></span>"
			+ appobj.developerName + "</td>"
	entry += "<td>"
			+ "<span style=\"display:inline-block; width: 5px;\"></span>"
			+ appobj.downloadCount
			+ "<span style=\"display:inline-block; width: 10px;\"></span>"
			+ "<a title=\"Download " + appobj.name
			+ " App\" href=\"app\\download\\" + appobj.fileName
			+ "\"> Download </a></td>"
	entry += "</td></tr>"
	return entry;
}

function displayAppDetails(app) {
	app = getSearchParams();
	var details = "<table style=\"width: 70%\";>";
	details += "<tr><td style=\"width: 30%\";>" + "App ID: " + "</td><td>"
			+ app.sId + "</td></tr>";
	details += "<tr><td>" + "Name: " + "</td><td>" + app.name
			+ "</td></tr>";
	details += "<tr><td>" + "Description: " + "</td><td>" + app.description
			+ "</td></tr>";
	details += "<tr><td>" + "Developer Name: " + "</td><td>"
			+ app.developerName + "</td></tr>";
	details += "<tr><td>" + "Developer Email: " + "</td><td>"
			+ app.developerEmail + "</td></tr>";
	details += "<tr><td>" + "Version: " + "</td><td>" + app.version
			+ "</td></tr>";
	var d = new Date(app.updatedTime);
	details += "<tr><td>" + "Last Updated on: " + "</td><td>" + d
			+ "</td></tr>";
	details += "<tr><td>" + "Download Count: " + "</td><td>"
			+ app.downloadCount + "</td></tr>";
	details += "<tr><td>" + "Tags: " + "</td><td>" + app.searchingTag
			+ "</td></tr>";
	details += "<tr><td>" + "Supported Platforms: " + "</td><td>"
			+ app.platformSupported + "</td></tr></table>";
	document.getElementById("utilDetails").innerHTML = details;
}

function getSearchParams() {
	var params = {}, pairs = document.URL.split('?').pop().split('&');

	for (var i = 0, p; i < pairs.length; i++) {
		p = pairs[i].split('=');
		params[p[0]] = p[1];
	}
	return JSON.parse(decodeURI(p[1]));
}

/* FILE CHECK */
function checkFile(fieldObj) {
	var FileName = fieldObj.value;
	var FileExt = FileName.substr(FileName.lastIndexOf('.') + 1);
	var ret = FileName.endsWith("tar.gz");

	if ((!ret) || FileSize > 20485760) {
		var error = "File type : " + FileExt + "\n\n";
		error += "Please make sure your file is in tar.gz format:.\n\n";
		fieldObj.value = null;
		alert(error);
		return false;
	}
	return true;
}