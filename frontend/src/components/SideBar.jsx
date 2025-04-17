import styles from "./SideBar.module.css"
import "./SideBar.module.css"
import { Children, useState } from "react";
import SideBarItem from "./SideBarItem";
import { Link } from "react-router";


export default function SideBar({ sideBarItems }) {

    return (
        <>
            <div className={styles.sideBar}>
                {sideBarItems.map((item) => <div><Link className={styles.link}to={item.path}>{item.name}</Link><br></br></div>)}
            </div>
        </>
    )
}