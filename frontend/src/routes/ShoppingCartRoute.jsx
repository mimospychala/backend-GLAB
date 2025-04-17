import ShoppingCartCards from "@/components/ShoppingCartCards";
import styles from "./ShoppingCartRoute.module.css"
import ShoppingcartFooter from "@/components/ShoppingCartFooter";
import SideBar from "@/components/SideBar";
import sideBarItems from "@/lib/data/sideBarItems";
import { useState } from "react";
import Button from "@/components/Button";


export default function ShoppingCartRoute(){

    return(
        <main className={styles.mainContent}>
        <div>
            <h3 className={styles.title}> Shoppingcart </h3>
            <SideBar sideBarItems={sideBarItems}/>
            <ShoppingCartCards />
            <ShoppingcartFooter/>
            
        </div>
        </main>

    )
}