	function getFormattedDate(date) {
	
	    var todayTime = new Date(date);
	
	    var month = todayTime.getMonth() + 1;
	
	    var day = todayTime.getDate();
	
	    var year = todayTime.getFullYear();
	
	    return month + "/" + day + "/" + year;
	
	}

	function loadProduct() {
		var content = document.getElementById("content");
		content.innerHTML = "";
		var request = new XMLHttpRequest;
		
		request.onreadystatechange = function() {
		if(request.readyState != 4)
		return;
		if(request.status != 200) {
		alert("Error return " + request.status);
		return;
	}
	
		var productJSON = JSON.parse(request.responseText);
		productJSON.forEach(product => {
		var productDiv = document.createElement("div");
		productDiv.setAttribute("id",product.boId);
		productDiv.setAttribute("onclick","getDetail(this,'PRODUCT');");
		var br = document.createElement("br");
		var nameSpan = document.createElement("span");
		var boIdSpan = document.createElement("span");
		nameSpan.innerHTML = product.name;
		boIdSpan.innerHTML = product.boId;
		productDiv.append(boIdSpan);
		productDiv.append(br);
		productDiv.append(nameSpan);
		var underlineSpan = document.createElement("hr");
		productDiv.append(underlineSpan);
		content.append(productDiv);
	
	});
	
	/*document.getElementById("product-content").onmouseover = function(){
	this.style.background = "grey";
	}*/
	
	}
	request.open("GET", "product/list", true);
	request.send();
	}
	
	
	function loadPurchaseOrder() {
		var content = document.getElementById("content");
		content.innerHTML = "";
		var request = new XMLHttpRequest;
		
		request.onreadystatechange = function() {
		if(request.readyState != 4)
		return;
		if(request.status != 200) {
		alert("Error return " + request.status);
		return;
	}
	
	var purchaseOrderJSON = JSON.parse(request.responseText);
	purchaseOrderJSON.forEach(purchaseOrder => {
	var purchaseOrderDiv = document.createElement("div");
	purchaseOrderDiv.setAttribute("id",purchaseOrder.boId);
	purchaseOrderDiv.setAttribute("onclick","getDetail(this,'PURCHASEORDER');");
	var br = document.createElement("br");
	var dateSpan = document.createElement("span");
	var boIdSpan = document.createElement("span");
	var purchaseDate = new Date(purchaseOrder.purchaseDate);
	dateSpan.innerHTML = getFormattedDate(purchaseDate);
	boIdSpan.innerHTML = purchaseOrder.boId;
	purchaseOrderDiv.append(boIdSpan);
	purchaseOrderDiv.append(br);
	purchaseOrderDiv.append(dateSpan);
	var underlineSpan = document.createElement("hr");
	purchaseOrderDiv.append(underlineSpan);
	content.append(purchaseOrderDiv);
	
	
	});
	
	/*document.getElementById("purchaseorder-content").onmouseover = function(){
	this.style.background = "grey";
	}*/
	
	}
	request.open("GET", "purchaseorder/list", true);
	request.send();
	}
	
	var detailId;
	function getDetail(element, entityType) {
	
	var request = new XMLHttpRequest;
	
	request.onreadystatechange = function() {
	if(request.readyState != 4)
		return;
	if(request.status != 200) {
		alert("Error return " + request.status);
		return;
	}
	document.getElementById("detail").innerHTML = request.responseText;
	document.getElementById("detail-table").className = "show";
	
	   if(entityType == "PRODUCT") {
		   document.getElementById("product-detail-table").className = "show";
	}
	else if(entityType == "PURCHASEORDER") {
		document.getElementById("purchaseorder-detail-table").className = "show";
	}
 }
	detailId = element;
	var boId = element.id;
	parameter = {};
	parameter["boId"] = boId;
	request.open("GET", "detail/"+ entityType + "?input=" + JSON.stringify(parameter), true);
	request.send();
 }