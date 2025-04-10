import LinkButton from "./LinkButton";
import styles from "./Button.module.css"
import "./Button.module.css"
import clsx from "clsx";

export default function Button({ to = "", children, className, ...props }) {
    const combinedClass = clsx(styles.button, className);
    return(
        <>
            {to ? <LinkButton to={to} className={combinedClass} {...props}>{children}</LinkButton> : <button className={styles.button} {...props}>{children}</button>}
        </>
    )
}