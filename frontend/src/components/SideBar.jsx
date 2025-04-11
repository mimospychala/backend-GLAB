import styles from "./SideBar.module.css"
import "./SideBar.module.css"
import { Children, useState } from "react";
import SideBarItem from "./SideBarItem";


export default function SideBar({ sideBarItems }) {

    return (
        <>
            <div className={styles.sideBar}>
                <h2>Side Bar</h2>
                {sideBarItems.map((item) => <SideBarItem title={item.name} items={item.children} />)}
            </div>
        </>
    )
}