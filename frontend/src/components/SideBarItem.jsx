import { Link } from "react-router";
import styles from "./SideBarItem.module.css"
import { useState } from "react"
export default function SideBarItem({ title, items = "", url = ""}) {   
    const [isOpen, setIsOpen] = useState(false);
    return (
        <div>
            {url ? <Link><h3>{title}</h3></Link> : <h3 onClick={() => setIsOpen(!isOpen)}>{title}</h3>}
            {isOpen && (
                <ul>
                    {items && items.map((item) => (
                            <li>
                            <SideBarItem title={item.name} items={item.children} url={item.url} />
                            </li>
                            ))   
                    }
                </ul>
            )}
        </div>
    );
}