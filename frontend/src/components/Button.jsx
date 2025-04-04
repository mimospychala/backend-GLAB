import LinkButton from "./LinkButton";
import styles from "./Button.module.css"
import "./Button.module.css"

export default function Button({to = "", children, ...props}){
    return(
        <>
            {to ? <LinkButton to={to} className={styles.button} {...props}>{children}</LinkButton> : <button className={styles.button} {...props}>{children}</button>}
        </>
    )
}