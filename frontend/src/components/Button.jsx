import LinkButton from "./LinkButton";
import styles from "./Button.module.css"
import "./Button.module.css"

export default function Button({ to = "", children, className="", ...props }) {
    const combinedClass = `${styles.button} ${className} `.trim();
    return(
        <>
            {to ? <LinkButton to={to} className={combinedClass} {...props}>{children}</LinkButton> : <button className={combinedClass} {...props}>{children}</button>}
        </>
    )
}