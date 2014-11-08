﻿var indexedDB = window.indexedDB || window.mozIndexedDB || window.webkitIndexedDB || window.msIndexedDB;

//prefixes of window.IDB objects
var IDBTransaction = window.IDBTransaction || window.webkitIDBTransaction || window.msIDBTransaction;
var IDBKeyRange = window.IDBKeyRange || window.webkitIDBKeyRange || window.msIDBKeyRange

if (!indexedDB) {
    alert("Your browser doesn't support a stable version of IndexedDB.")
}

var userData = [
  { id: "1", name: "Tapas", age: 33, email: "tapas@example.com" },
  { id: "2", name: "Bidulata", age: 55, email: "bidu@home.com" }
];

var db;
var request = indexedDB.open("newDatabase", 1);

request.onerror = function (e) {
    console.log("error: ", e);
};

request.onsuccess = function (e) {
    db = request.result;
    console.log("success: " + db);
};

request.onupgradeneeded = function (event) {

}

request.onupgradeneeded = function (event) {
    var objectStore = event.target.result.createObjectStore("users", { keyPath: "id" });
    for (var i in userData) {
        objectStore.add(userData[i]);
    }
}

function Add() {
    var request = db.transaction(["users"], "readwrite")
            .objectStore("users")
            //.add({ id: "3", name: "Gautam", age: 30, email: "gautam@store.org" });
            .add({ id: "4", name: "Jim", age: 30, email: "jimjones@store.org" });

    request.onsuccess = function (e) {
        alert("Gautam has been added to the database.");
    };

    request.onerror = function (e) {
        alert("Unable to add the information.");
    }

}

function Read() {
    var objectStore = db.transaction("users").objectStore("users");
    var request = objectStore.get("2");
    request.onerror = function (event) {
        alert("Unable to retrieve data from database!");
    };
    request.onsuccess = function (event) {
        if (request.result) {
            alert("Name: " + request.result.name + ", Age: " + request.result.age + ", Email: " + request.result.email);
        } else {
            alert("Bidulata couldn't be found in your database!");
        }
    };
}

function ReadAll() {
    var objectStore = db.transaction("users").objectStore("users");
    var req = objectStore.openCursor();

    req.onsuccess = function (event) {
        db.close();
        var res = event.target.result;
        if (res) {
            alert("Key " + res.key + " is " + res.value.name + ", Age: " + res.value.age + ", Email: " + res.value.email);
            res.continue();
        }
    };

    req.onerror = function (e) {
        console.log("Error Getting: ", e);
    };
}

function Remove() {
    var request = db.transaction(["users"], "readwrite").objectStore("users").delete("1");
    request.onsuccess = function (event) {
        alert("Tapas's entry has been removed from your database.");
    };
}


var obj = {
    Text1: undefined,
    Text2: undefined
}

