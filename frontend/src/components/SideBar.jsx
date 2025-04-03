import styles from "./SideBar.module.css"
import "./SideBar.module.css"
import { useState } from "react";
import SideBarItem from "./SideBarItem";

export default function SideBar() {



    return (
        <div className={styles.sidebar}>
        <SideBarItem title="Drinks" products={["Energi", "Alc", "Shakes"]} />
        <SideBarItem title="Snacks" products={["süss", "salzig"]} />
    </div>

    )
}