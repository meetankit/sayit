'use strict';

// TODO
console.log('in main js file');
if ('serviceWorker' in navigator) {
    console.log('Service Worker is supported');
    navigator.serviceWorker.register('sw.js').then(function(reg) {
        console.log(':^)', reg);
        reg.pushManager.subscribe({
            userVisibleOnly: true
        }).then(function(sub) {
            console.log('endpoint:', sub.endpoint);
            var regId=sub.endpoint;
            console.log('regId:', regId);
            $.ajax({
            	  type: "POST",
            	  url: "/api/v1/register", // the method we are calling
            	  contentType: "application/json; charset=utf-8",
            	  dataType: "json",
            	  data: "{\"user\":\"test\", \"regId\":" + encodeURIComponent(regId) + "}",
            	  success: function (result) {
            	      alert('Yay! It worked!');
            	      // Or if you are returning something
            	    //  alert('I returned... ' + result.WhateverIsReturning);                    
            	  },
            	  error: function (result) {
            	      alert('Oh no :(');
            	  }
            	});
        });
    }).catch(function(error) {
        console.log(':^(', error);
    });
}

// Let's edit the description!
