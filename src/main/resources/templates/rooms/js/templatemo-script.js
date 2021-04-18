"use strict";

const roomsContainer = document.querySelector(".tm-bg-controls-wrapper");
const rooms = document.querySelectorAll(".tm-bg-control");
console.log(rooms);

const initBg = (autoplay = true) => {
  const bgImgsNames = [
    "diagoona-bg-1.jpg",
    "diagoona-bg-2.jpg",
    "diagoona-bg-3.jpg",
  ];

  const bgImgs = bgImgsNames.map((img) => "img/" + img);

  $.backstretch(bgImgs, { duration: 4000, fade: 500 });

  if (!autoplay) {
    $.backstretch("pause");
  }
};

const setBg = (id) => {
  $.backstretch("show", id);
};

const setBgOverlay = () => {
  const windowWidth = window.innerWidth;
  const bgHeight = $("body").height();
  const tmBgLeft = $(".tm-bg-left");

  $(".tm-bg").height(bgHeight);

  if (windowWidth > 768) {
    tmBgLeft
      .css("border-left", `0`)
      .css("border-top", `${bgHeight}px solid transparent`);
  } else {
    tmBgLeft
      .css("border-left", `${windowWidth}px solid transparent`)
      .css("border-top", `0`);
  }
};

$(document).ready(function () {
  const autoplayBg = false; // set Auto Play for Background Images
  initBg(autoplayBg);
  setBgOverlay();

  const bgControl = $(".tm-bg-control");
  bgControl.click(function () {
    // bgControl.removeClass("active");
    // $(this).addClass("active");
    const id = $(this).data("id");
    setBg(id);
  });

  $(window).on("backstretch.after", function (_, __, index) {
    const bgControl = $(".tm-bg-control");
    bgControl.removeClass("active");
    const current = $(".tm-bg-controls-wrapper").find(`[data-id=${index}]`);
    // current.addClass("active");
  });

  $(window).resize(function () {
    setBgOverlay();
  });
});

roomsContainer.addEventListener("click", function (e) {
  e.preventDefault();

  const clicked = e.target.closest(".tm-bg-control");
  console.log(clicked);
  if (!clicked) return;

  const bgImgsNames = [
    "diagoona-bg-1.jpg",
    "diagoona-bg-2.jpg",
    "diagoona-bg-3.jpg",
  ];

  const bgImgs = bgImgsNames.map((img) => "img/" + img);

  const roomPages = ["about.html", "services.html", "contact.html"];

  if (clicked.classList[0] === "tm-bg-control") {
    const id = e.target.dataset.id;
    setBg(id);

    rooms.forEach((btn) => btn.classList.remove("tm-bg-control--active"));
    clicked.classList.add("tm-bg-control--active");

    window.location.replace(roomPages[id]);
    console.log(clicked);
  }
});
