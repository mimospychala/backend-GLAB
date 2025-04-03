import styles from "./SideBarItem.module.css"
import { useState } from "react"

export default function SideBarItem({ title, products }){
    const [isOpen, setIsOpen] = useState(false);

    return(
        
        <div>
            <h3 onClick={() => setIsOpen(!isOpen)}>{title}</h3>
            {isOpen && (
               
               <ul>
               {products.map((product, index) => (
                   <li key={index}>
                       <a href="#">{product}</a>
                   </li>
               ))}
           </ul>
       )}
   </div>
);
}