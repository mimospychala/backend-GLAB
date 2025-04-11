import styles from "./Header.module.css"
import "./Header.module.css"



export default function Header (){

    return(
        <header>
            

            <div className={styles.header}>
            <div className={styles.filler}>
            </div>
                <img src="/logo.png" alt="Logo Nom Nom Bar" className={styles.logo} />
            </div> 
            

        </header>

    )
}