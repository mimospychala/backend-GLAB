import React from "react";

import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faShareAlt } from "@fortawesome/free-solid-svg-icons";
import { Share2 } from "lucide-react";
import Button from "./Button";

export default function ShareButton(){
  const handleShare = async () => {
    if (navigator.share) {
      try {
        await navigator.share({
          title: "Meine Webseite",
          text: "Schau dir diese coole Seite an!",
          url: window.location.href,
        });
        console.log("Erfolgreich geteilt!");
      } catch (error) {
        console.error("Fehler beim Teilen:", error);
      }
    } else {
      alert("Teilen wird von deinem Browser nicht unterstützt.");
    }
  }

  return (
    <Button onClick={handleShare}>
      <Share2/>
    </Button>
  )
}