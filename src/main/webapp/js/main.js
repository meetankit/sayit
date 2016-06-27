'use strict';

// TODO
console.log('in main js file');

if ('serviceWorker' in navigator) {
    console.log('Service Worker is supported');
    navigator.serviceWorker.register('sw.js').then(function(reg) {
        console.log(':^)', reg);
        $('#send').on('click', function () {
        	console.log("sending mesage");
        	 $.ajax({
           	  type: "POST",
           	  url: "/api/v1/message/send", // the method we are calling
           	  contentType: "application/json; charset=utf-8",
           	  data: "{\"message\":\""+ $("#message").val() + "\", \"to\":\"" + $("#user").val() + "\"}"
           	});
        } );
        reg.pushManager.subscribe({
            userVisibleOnly: true
        }).then(function(sub) {
            console.log('endpoint:', sub.endpoint);
            var regId=encodeURIComponent(sub.endpoint);
            $.ajax({
            	  type: "POST",
            	  url: "/api/v1/register", // the method we are calling
            	  contentType: "application/json; charset=utf-8",
            	  data: "{\"user\":\""+ $("#user").val() + "\", \"regId\":\"" + regId + "\"}"
            	});
        });
    }).catch(function(error) {
        console.log(':^(', error);
    });
}

// Let's edit the description!
