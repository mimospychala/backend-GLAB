import styles from "./Header.module.css"
import "./Header.module.css"



export default function Header (){

    return(
        <header>
            <div className={styles.header}>
                <img src="/logo.png" alt="Logo Nom Nom Bar" className={styles.logo} />
            </div> 
        </header>

    )
}