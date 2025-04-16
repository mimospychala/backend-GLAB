import { Form } from "react-router"

import Input from "./Input"
import Button from "./Button"
import ButtonGroup from "./ButtonGroup"

export default function RegistrationForm({ user = {}, errors = {}, onCancel }) {
    return (
        <Form method="post">
            <Input
                label="E-Mail:"
                type="email"
                name="email"
                placeholder="Bitte eine E-Mail Adresse eingeben"
                error={errors.email}
                defaultValue={user.email}
            />

            <Input
                label="Benutzername:"
                type="text"
                name="username"
                placeholder="Bitte einen Benutzernamen eingeben"
                error={errors.username}
                defaultValue={user.username}
            />

            <Input
                label="Passwort:"
                type="password"
                name="password"
                placeholder="Bitte ein Passwort eingeben"
                error={errors.password}
                defaultValue={user.password}
            />
            <ButtonGroup>
                <Button type="submit">Speichern</Button>
                <Button type="button" secondary onClick={onCancel}>
                    Abbrechen
                </Button>
            </ButtonGroup>
        </Form>
    )
}
