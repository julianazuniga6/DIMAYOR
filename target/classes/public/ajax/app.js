function teams() {
  console.log("retreive data");
  var dmJSON = "/api/v1/teams";
  $.getJSON( dmJSON, function(data) {
    var items=[];
    console.log(data);

   $.each(data, function(key, val) {
     items.push("<tr>");
     items.push("<td>"+val.name+"</td>");
     items.push("<td>"+val.year+"</td>");
     items.push("<td>"+val.titles+"</td>");
     items.push("</tr>");
   });
   $("<tbody/>", {html: items.join("")}).appendTo("table");

});
}

teams();
